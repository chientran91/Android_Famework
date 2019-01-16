package com.chiennd.demo.database.sql;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;

import com.chiennd.demo.database.DBInfor;
import com.chiennd.demo.database.TableInfor;
import com.chiennd.demo.database.entity.User;
import com.chiennd.demo.database.provider.ICursor;
import com.chiennd.demo.utility.CollectionUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UserSQLiteAccess extends SQLiteAccess {

    public final static Uri getContentUri(Context ctx) {
        Uri uri = Uri.parse("content://" + DBInfor.getAuthority(ctx) + "/" + DBInfor.USER_TABLE);
        return uri;

    }

    public static User convertToUserRec(Cursor cursor) {
        User rec = new User();
        rec.setId(cursor.getString(cursor.getColumnIndex(TableInfor.User._ID)));
        rec.setFirstName(cursor.getString(cursor.getColumnIndex(TableInfor.User.FIRST_NAME)));

        return rec;
    }

    public static ContentValues convertToContentValues(User rec) {
        ContentValues values = new ContentValues();
        values.put(TableInfor.User._ID, rec.getId());
        values.put(TableInfor.User.FIRST_NAME, rec.getFirstName());
        return values;
    }

    public static ContentValues[] convertToContentValues(List<User> list) {
        List<ContentValues> valuesList = new ArrayList<>();
        for (User rec : list) {
            ContentValues values = convertToContentValues(rec);
            valuesList.add(values);
        }
        return valuesList.toArray(new ContentValues[0]);
    }

    public static User queryById(Context context, String id, int ownerId) {
        String selection = TableInfor.User._ID + "='" + id + "'"
                + " AND " + TableInfor.User.ID_OWNER + "=" + ownerId;
        List<User> list = query(context, selection);

        if (!CollectionUtil.isEmpty(list)) {
            return list.get(0);
        }
        return null;
    }

    public static List<User> queryAll(Context context, int ownerId) {
        String selection = TableInfor.User.ID_OWNER + "= " + ownerId;
        return query(context, selection);
    }


    /**
     * @param context
     * @param column
     * @param value
     * @return
     * @des: Check exist column
     */
    public static boolean checkExistColumn(Context context, String column, String value) {
        try {
            String selection = column + "='" + value + "'";
            String orderBy = TableInfor.CBaseColumns._ID;
            query(context, selection, orderBy, "1");
            return true;
        } catch (Exception ex) {
        }
        return false;
    }

    public static List<User> query(Context context, String selection) {
        return queryUsers(context, selection, null, null, new ICursor<User>() {
            @Override
            public User pare(Cursor cursor) {
                return convertToUserRec(cursor);
            }
        });
    }

    public static List<User> query(Context context, String selection, String orderBy, String limit) {
        return queryUsers(context, selection, orderBy, limit, new ICursor<User>() {
            @Override
            public User pare(Cursor cursor) {
                return convertToUserRec(cursor);
            }
        });
    }

    /***
     * @param context
     * @param rec
     * @return the row ID of the newly inserted row, or -1 if an error occurred
     */
    public static int insert(Context context, User rec) {
        CSQLiteOpenHelper helper = new CSQLiteOpenHelper(context);
        SQLiteDatabase db = helper.getWritableDatabase();
        int result = (int) db.insert(DBInfor.USER_TABLE, "", convertToContentValues(rec));
        db.close();
        return result;
    }

    public static int insertRecBatch(Context context, List<User> list) {
        CSQLiteOpenHelper helper = new CSQLiteOpenHelper(context);
        final SQLiteDatabase db = helper.getWritableDatabase();
        db.beginTransaction();
        int returnCount = 0;
        try {
            ContentValues[] values = convertToContentValues(list);
            for (ContentValues value : values) {
                int result = (int) db.insert(DBInfor.USER_TABLE, "", value);
                if (result != -1) {
                    returnCount++;
                }
            }
            db.setTransactionSuccessful();
        } finally {
            db.endTransaction();
        }
        context.getContentResolver().notifyChange(getContentUri(context), null);
        return returnCount;
    }

    public static int updateRec(Context context, User rec) {
        CSQLiteOpenHelper helper = new CSQLiteOpenHelper(context);
        SQLiteDatabase db = helper.getWritableDatabase();
        // New value for one column
        ContentValues values = convertToContentValues(rec);

        // Which row to update, based on the ID
        String whereClause = TableInfor.CBaseColumns._ID + " = ?";
        String[] whereArgs = {String.valueOf(rec.getId())};
        int count = db.update(
                DBInfor.USER_TABLE,
                values,
                whereClause,
                whereArgs);
        db.close();
        return count;
    }

    /**
     * @param context
     * @param list
     * @Desc function to update multi rec
     */
    public static int updateRecBatch(Context context, List<User> list) {
        CSQLiteOpenHelper helper = new CSQLiteOpenHelper(context);
        final SQLiteDatabase db = helper.getWritableDatabase();
        db.beginTransaction();
        int returnCount = 0;
        try {
            // Which row to update, based on the ID
            String selection = TableInfor.CBaseColumns._ID + " = ?";
            for (User rec : list) {
                String[] selectionArgs = {String.valueOf(rec.getId())};
                int result = db.update(
                        DBInfor.USER_TABLE,
                        convertToContentValues(rec),
                        selection,
                        selectionArgs);
                if (result != -1) {
                    returnCount++;
                }
            }
            db.setTransactionSuccessful();
        } finally {
            db.endTransaction();
        }
        context.getContentResolver().notifyChange(getContentUri(context), null);
        return returnCount;
    }

    public static int deleteRec(Context context, List<User> recList) {
        List<String> idList = new ArrayList<>();
        for (User rec : recList) {
            idList.add(rec.getId());
        }
        String idStr = Arrays.toString(idList.toArray(new Integer[0])).replace("[", "(").replace("]", ")");
        String selection = TableInfor.CBaseColumns._ID + " IN " + idStr;

        CSQLiteOpenHelper helper = new CSQLiteOpenHelper(context);
        SQLiteDatabase db = helper.getWritableDatabase();
        return db.delete(DBInfor.USER_TABLE, selection, null);
    }
}

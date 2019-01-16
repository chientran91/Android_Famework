package com.chiennd.demo.database.sql;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;
import android.database.sqlite.SQLiteStatement;
import android.net.Uri;
import android.text.TextUtils;

import com.chiennd.demo.database.DBInfor;
import com.chiennd.demo.database.TableInfor;

public class UserProvider extends SQLiteProvider {
    public UserProvider(Context context, CSQLiteOpenHelper db) {
        super(context, db);
    }

    @Override
    public String getTableName() {
        return DBInfor.USER_TABLE;
    }

    @Override
    public Uri insert(Uri uri, ContentValues initialValues) {
        ContentValues values;
        if (initialValues != null) {
            values = new ContentValues(initialValues);
        } else {
            values = new ContentValues();
        }

        if (values.containsKey(TableInfor.CBaseColumns._ID) == false) {
            Uri noteUri = getInsertResultUri(-1, INSERT_RESULT_FAILED);
            mContext.getContentResolver().notifyChange(noteUri, null);
            return noteUri;
        }

        int id;
        if ((id = isExist(TableInfor.CBaseColumns._ID + "='" + convertQuote(values.getAsString(TableInfor.User.ID_OWNER)) + "'")) != -1) {
            Uri noteUri = getInsertResultUri(id, INSERT_RESULT_CONFLICT);
            mContext.getContentResolver().notifyChange(noteUri, null);
            return noteUri;
        }

        SQLiteDatabase db = mDb.getWritableDatabase();
        //standard SQL insert statement, that can be reused
        SQLiteStatement insert =
                db.compileStatement("insert into " + getTableName()
                        + "("
                        + TableInfor.User._ID + ","
                        + TableInfor.User.ID_OWNER + ","
                        + TableInfor.User.FIRST_NAME + ","
                        + TableInfor.User.LAST_NAME
                        + ")"
                        + " values " + "(?,?,?,?)");

        insert.bindString(1, values.getAsString(TableInfor.User._ID));
        insert.bindString(2, values.getAsString(TableInfor.User.ID_OWNER));
        insert.bindString(3, values.getAsString(TableInfor.User.FIRST_NAME));
        insert.bindString(4, values.getAsString(TableInfor.User.LAST_NAME));

        long rowId = insert.executeInsert();

        if (rowId > 0) {
            Uri noteUri = getInsertResultUri((int) rowId, INSERT_RESULT_SUCCESS);
            mContext.getContentResolver().notifyChange(noteUri, null);
            return noteUri;
        }

        throw new SQLException("Failed to insert row into " + uri);
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        SQLiteDatabase db = mDb.getWritableDatabase();
        int ret = db.delete(getTableName(), selection, selectionArgs);
        return ret;
    }

    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        SQLiteDatabase db = mDb.getReadableDatabase();
        SQLiteQueryBuilder qb = new SQLiteQueryBuilder();

        qb.setTables(getTableName());

        // If no sort order is specified use the default
        String orderBy;
        if (TextUtils.isEmpty(sortOrder)) {
            orderBy = TableInfor.User.ID_NO + " 111";
        } else {
            orderBy = sortOrder;
        }

        // Get the database and run the query
        Cursor c = qb.query(db, projection, selection, selectionArgs, null, null, orderBy);

        // Tell the cursor what uri to watch, so it knows when its source data changes
        c.setNotificationUri(mContext.getContentResolver(), uri);
        return c;
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
        SQLiteDatabase db = mDb.getWritableDatabase();
        int ret = db.update(getTableName(), values, selection, selectionArgs);
        return ret;
    }
}

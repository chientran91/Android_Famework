package com.chiennd.ex.database.sql;

import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;

import com.chiennd.ex.database.DBInfor;
import com.chiennd.ex.database.TableInfor;

public abstract class SQLiteProvider {

    public final static String INSERT_RESULT_SUCCESS = "success";
    public final static String INSERT_RESULT_CONFLICT = "conflict";
    public final static String INSERT_RESULT_FAILED = "failed";

    protected CSQLiteOpenHelper mDb ;
    protected Context mContext ;

    public SQLiteProvider(Context context, CSQLiteOpenHelper db){
        this.mDb = db;
        this.mContext = context;
    }
    public abstract String getTableName();

    public abstract Uri insert(Uri uri, ContentValues initialValues);
    public abstract int delete(Uri uri, String selection, String[] selectionArgs);
    public abstract Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder);
    public abstract int update(Uri uri, ContentValues values, String selection, String[] selectionArgs);

    /***
     *
     * @param condition
     * @return id if exist or -1  if not exist
     */
    public int isExist(String condition){
        SQLiteDatabase db = mDb.getReadableDatabase();
        String[] projection = {TableInfor.CBaseColumns._ID};
        Cursor cursor = db.query(getTableName(), projection, condition,	null, null, null, null, "1");
        if(cursor == null){
            return -1;
        }
        if(cursor.getCount() == 0){
            cursor.close();
            return -1;
        }
        if(!cursor.moveToFirst()){
            cursor.close();
            return -1;
        }
        int idx_id = cursor.getColumnIndex(projection[0]);
        int ret = cursor.getInt(idx_id);
        cursor.close();
        return ret;
    }

    public Uri getInsertResultUri(int id, String type){
        Uri noteUri = ContentUris.withAppendedId(Uri.parse("content://" + DBInfor.getAuthority(mContext) + "/" + getTableName() + "/" + type), id);
        return noteUri;
    }

    static public String convertQuote(String value)
    {
        if (value != null)
            return value.replaceAll("'", "''");
        else
            return "";
    }
}

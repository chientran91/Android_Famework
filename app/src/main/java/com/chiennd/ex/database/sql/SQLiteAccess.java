package com.chiennd.ex.database.sql;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.chiennd.ex.database.DBInfor;
import com.chiennd.ex.database.provider.ICursor;

import java.util.ArrayList;
import java.util.List;

public class SQLiteAccess {

    protected static <T extends Object> List<T> queryUsers(Context context, String selection, String orderBy, String limit, ICursor<T> iParseCursor) {
        return query(context, DBInfor.USER_TABLE, selection, orderBy, limit, iParseCursor);
    }


    protected static <T extends Object> List<T> query(Context context, String table, String selection, String orderBy, String limit, ICursor<T> iParseCursor) {
        CSQLiteOpenHelper dbHelper = new CSQLiteOpenHelper(context);
        SQLiteDatabase db = dbHelper.getReadableDatabase();

        Cursor cursor = db.query(table, null, selection,
                null, null, null, orderBy, limit);

        List<T> list = null;

        if (cursor != null && cursor.moveToFirst()) {
            list = new ArrayList<>();
            do {
                list.add(iParseCursor.pare(cursor));
            } while (cursor.moveToNext());
        }

        if (cursor != null) {
            cursor.close();
        }
        db.close();

        return list;
    }
}

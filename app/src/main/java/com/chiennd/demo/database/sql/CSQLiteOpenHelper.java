package com.chiennd.demo.database.sql;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.chiennd.demo.database.DBInfor;

public class CSQLiteOpenHelper extends SQLiteOpenHelper {

    private static final int DB_VERSION = 1;

    public CSQLiteOpenHelper(Context context) {
        super(context, DBInfor.NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}

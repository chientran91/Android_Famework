package com.chiennd.demo.database.sql;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.chiennd.demo.app.CApplication;
import com.chiennd.demo.database.DBInfor;
import com.chiennd.demo.database.TableInfor;

public class CSQLiteOpenHelper extends SQLiteOpenHelper {
    public static final String TAG = CSQLiteOpenHelper.class.getName();

    private static final int DB_VERSION = 1;

    public CSQLiteOpenHelper(Context context) {
        super(context, DBInfor.NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        createUserTable(db);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        int version = oldVersion + 1;
        while (version <= newVersion) {
            doUpgrade(db, version);
            version++;
        }

    }

    protected boolean doUpgrade(SQLiteDatabase db, int version) {
        try {
            switch (version) {
                case 2:
                    addColumnUserTableV2(CApplication.getInstance(), db);
                    break;
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    private static void createUserTable(SQLiteDatabase db) {
        db.execSQL(new StringBuilder().append("CREATE TABLE IF NOT EXISTS ").append(DBInfor.USER_TABLE).append(" ( ")
                .append(TableInfor.User._ID).append(" INTEGER PRIMARY KEY, ")
                .append(TableInfor.User.FIRST_NAME).append(" TEXT, ")
                .append(TableInfor.User.LAST_NAME).append(" TEXT, ")
                .append(TableInfor.User.ID_NO).append(" TEXT NOT NULL, ")
                .append(TableInfor.User.BIRTH_DAY).append(" INTEGER DEFAULT 0, ")
                .append(")")
                .toString());

        db.execSQL("CREATE INDEX IF NOT EXISTS " + DBInfor.USER_TABLE + "_idx1 ON " + DBInfor.USER_TABLE +
                " (" + TableInfor.User.FIRST_NAME + ")");
        db.execSQL("CREATE INDEX IF NOT EXISTS " + DBInfor.USER_TABLE + "_idx2 ON " + DBInfor.USER_TABLE +
                " (" + TableInfor.User.LAST_NAME + ")");
        db.execSQL("CREATE INDEX IF NOT EXISTS " + DBInfor.USER_TABLE + "_idx3 ON " + DBInfor.USER_TABLE +
                " (" + TableInfor.User.ID_NO + ")");
        db.execSQL("CREATE INDEX IF NOT EXISTS " + DBInfor.USER_TABLE + "_idx4 ON " + DBInfor.USER_TABLE +
                " (" + TableInfor.User.BIRTH_DAY + ")");

    }

    // Call when creat DB
    public static void createSQLiteTable(Context context) {
        try {
            CSQLiteOpenHelper dbHelper = new CSQLiteOpenHelper(context);
            SQLiteDatabase db = dbHelper.getWritableDatabase();

            if (!exists(db, DBInfor.USER_TABLE)) {
                createUserTable(db);
            }
            checkColumnUserTableV2(context, db);

        } catch (Exception e) {

        }
    }

    private static boolean exists(SQLiteDatabase db, String table) {
        try {
            db.execSQL("SELECT * FROM " + table);
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

    private static void checkColumnUserTableV2(Context context, SQLiteDatabase db) {
        /**
         * Alter @table USER_TABLE
         */
        if (!UserSQLiteAccess.checkExistColumn(context, TableInfor.User.FIRST_NAME, "")) {
            addColumnUserTableV2(context, db);
        } else {
            Log.e(TAG, "checkColumnUserTableV2... exist");
        }
    }

    private static void addColumnUserTableV2(Context context, SQLiteDatabase db) {
        /**
         * Alter @table USER_TABLE
         */
        try {
            if (!db.isOpen()) {
                CSQLiteOpenHelper mDbHelper = new CSQLiteOpenHelper(context);
                db = mDbHelper.getWritableDatabase();
            }

            String sql = new StringBuilder()
                    .append("ALTER TABLE ").append(DBInfor.USER_TABLE).append(" ADD ")
                    .append(TableInfor.User.FIRST_NAME).append(" TEXT").append(";")
                    .toString();
            db.execSQL(sql);

            sql = new StringBuilder()
                    .append("ALTER TABLE ").append(DBInfor.USER_TABLE).append(" ADD ")
                    .append(TableInfor.User.BIRTH_DAY).append(" INTEGER DEFAULT 0").append(";")
                    .toString();
            db.execSQL(sql);

        } catch (Exception ex) {
            Log.e(TAG, "addColumnUserTableV2 add column... error " + ex.getMessage());
        } finally {
        }
    }
}

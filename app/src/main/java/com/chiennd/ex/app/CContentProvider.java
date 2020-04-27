package com.chiennd.ex.app;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.net.Uri;

import com.chiennd.ex.database.DBInfor;
import com.chiennd.ex.database.sql.CSQLiteOpenHelper;
import com.chiennd.ex.database.sql.SQLiteProvider;
import com.chiennd.ex.database.sql.UserProvider;

import java.util.HashMap;
import java.util.Map;


public class CContentProvider extends ContentProvider {

    public static final int TABLE_TYPE_USER_ENTRIES = 0x00;
    public static final int TABLE_TYPE_USER_ENTRY_ID = 0x01;
    protected UriMatcher uriMatcher = null;
    private CSQLiteOpenHelper helper = null;
    private Map<String, SQLiteProvider> providerMap = null;

    @Override
    public boolean onCreate() {
        helper = new CSQLiteOpenHelper(getContext());
        uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
        uriMatcher.addURI(DBInfor.getAuthority(getContext()), DBInfor.USER_TABLE, TABLE_TYPE_USER_ENTRIES);
        uriMatcher.addURI(DBInfor.getAuthority(getContext()), DBInfor.USER_TABLE + "/id/#", TABLE_TYPE_USER_ENTRY_ID);

        providerMap = new HashMap<>();
        providerMap.put(DBInfor.USER_TABLE, new UserProvider(getContext(), helper));
        return true;
    }

    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        synchronized (this) {
            SQLiteProvider provider = getDbProvider(uri);
            return provider.query(uri, projection, selection, selectionArgs, sortOrder);
        }
    }


    @Override
    public String getType(Uri uri) {
        return null;
    }


    @Override
    public Uri insert(Uri uri, ContentValues values) {
        synchronized (this) {
            SQLiteProvider provider = getDbProvider(uri);
            return provider.insert(uri, values);
        }
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        synchronized (this) {
            SQLiteProvider provider = getDbProvider(uri);
            return provider.delete(uri, selection, selectionArgs);
        }
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
        synchronized (this) {
            SQLiteProvider provider = getDbProvider(uri);
            return provider.update(uri, values, selection, selectionArgs);
        }
    }

    protected SQLiteProvider getDbProvider(Uri uri) {
        switch (uriMatcher.match(uri)) {
            case TABLE_TYPE_USER_ENTRIES:
                return providerMap.get(DBInfor.USER_TABLE);
            case TABLE_TYPE_USER_ENTRY_ID:
                return providerMap.get(DBInfor.USER_TABLE);
            default:
                throw new IllegalArgumentException("Unknown URI " + uri);
        }
    }

}

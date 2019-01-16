package com.chiennd.demo.database.provider;

import android.database.Cursor;

public interface ICursor<T extends Object> {
    T pare(Cursor cursor);
}

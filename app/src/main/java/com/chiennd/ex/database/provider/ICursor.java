package com.chiennd.ex.database.provider;

import android.database.Cursor;

public interface ICursor<T extends Object> {
    T pare(Cursor cursor);
}

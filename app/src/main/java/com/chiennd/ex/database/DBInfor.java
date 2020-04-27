package com.chiennd.ex.database;

import android.content.Context;

public class DBInfor {
    public static final String NAME = "com_chiennd_demo.db";
    public static final String MESSAGE_TABLE = "message";
    public static final String USER_TABLE = "user";
    public static final String PRODUCT_TABLE = "user";

    private DBInfor() {
    }

    public static String getAuthority(Context cxt) {
        return cxt.getPackageName() + ".provider";
    }

}

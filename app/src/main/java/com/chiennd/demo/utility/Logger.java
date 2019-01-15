package com.chiennd.demo.utility;

import android.util.Log;

import com.chiennd.demo.BuildConfig;

public class Logger {
    public static void e(Object object)
    {
        if (BuildConfig.DEBUG_MODE) {
            Log.e("Mi6App", "test: " + object);
        }
    }
    public static void e(String TAG, String msg) {
        if (BuildConfig.DEBUG_MODE) {
            Log.e(TAG, msg);
        }
    }

    public static void d(String TAG, String msg) {
        if (BuildConfig.DEBUG_MODE) {
            Log.d(TAG, msg);
        }
    }

    public static void w(String TAG, String msg) {
        if (BuildConfig.DEBUG_MODE) {
            Log.w(TAG, msg);
        }
    }

    public static void v(String TAG, String msg) {
        if (BuildConfig.DEBUG_MODE) {
            Log.v(TAG, msg);
        }
    }
    public static void i(String TAG, String msg) {
        if (BuildConfig.DEBUG_MODE) {
            Log.i(TAG, msg);
        }
    }
}

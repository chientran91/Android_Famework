package com.ch.nd.utility;

import android.util.Log;

import com.ch.nd.BuildConfig;

public class Logger {
    public static void e(String TAG, Object object) {
        if (BuildConfig.DEBUG_MODE) {
            Log.e(TAG, object.toString());
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

package com.ch.nd.app;

import android.app.Application;
import android.content.Context;
import android.support.multidex.MultiDex;

public class CApplication extends Application {
    private static CApplication instance;
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        instance =this;
        MultiDex.install(this);
    }
    public static synchronized CApplication getInstance() {
        return instance;
    }
}

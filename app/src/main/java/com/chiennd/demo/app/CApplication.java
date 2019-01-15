package com.chiennd.demo.app;

import android.app.Application;
import android.content.Context;
import android.support.multidex.MultiDex;

public class CApplication extends Application {
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }
}

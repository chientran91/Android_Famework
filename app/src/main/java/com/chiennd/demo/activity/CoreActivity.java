package com.chiennd.demo.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.chiennd.demo.utility.Constant;
import com.chiennd.demo.utility.Logger;

public abstract class CoreActivity extends AppCompatActivity {

    protected abstract String getTag();

    protected abstract void init();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init();
        Logger.d(getTag(), Constant.TypeLogger.LIFECYCLE + " onCreate");
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        Logger.d(getTag(), Constant.TypeLogger.LIFECYCLE + " onCreate persistentState");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Logger.d(getTag(), Constant.TypeLogger.LIFECYCLE + " onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Logger.d(getTag(), Constant.TypeLogger.LIFECYCLE + " onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Logger.d(getTag(), Constant.TypeLogger.LIFECYCLE + " onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Logger.d(getTag(), Constant.TypeLogger.LIFECYCLE + " onStop");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Logger.d(getTag(), Constant.TypeLogger.LIFECYCLE + " onRestart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Logger.d(getTag(), Constant.TypeLogger.LIFECYCLE + " onDestroy");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Logger.d(getTag(), Constant.TypeLogger.LIFECYCLE + " onSaveInstanceState");
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Logger.d(getTag(), Constant.TypeLogger.LIFECYCLE + " onRestoreInstanceState");
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Logger.d(getTag(), Constant.TypeLogger.LIFECYCLE + " onBackPressed");
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Logger.d(getTag(), Constant.TypeLogger.LIFECYCLE + " onActivityResult");
    }
}

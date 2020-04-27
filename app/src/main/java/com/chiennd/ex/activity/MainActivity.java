package com.chiennd.ex.activity;

import android.os.Bundle;

import com.chiennd.ex.R;

public class MainActivity extends BaseActivity {

    @Override
    protected String getTag() {
        return null;
    }

    @Override
    protected void init() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected int getLayoutResoure() {
        return 0;
    }

    @Override
    protected void bindDataToView() {

    }
}

package com.ch.nd.activity;


import androidx.annotation.LayoutRes;

public abstract class BaseActivity extends CoreActivity {

    @LayoutRes
    protected abstract int getLayoutResource();

    protected abstract void bindDataToView();

    @Override
    protected void onResume() {
        super.onResume();
    }
}

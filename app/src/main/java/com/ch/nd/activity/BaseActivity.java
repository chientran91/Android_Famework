package com.ch.nd.activity;


import android.os.Bundle;

import androidx.annotation.LayoutRes;
import androidx.annotation.Nullable;



public abstract class BaseActivity extends CoreActivity {

    @LayoutRes
    protected abstract int getLayoutResource();

    protected abstract void initView();

    protected abstract void bindDataToView();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutResource());
        initView();
    }
}

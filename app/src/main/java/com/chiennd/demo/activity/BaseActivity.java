package com.chiennd.demo.activity;

import android.support.annotation.LayoutRes;

public abstract class BaseActivity extends CoreActivity {

    @LayoutRes
    protected abstract int getLayoutResoure();

    protected abstract void bindDataToView();

}

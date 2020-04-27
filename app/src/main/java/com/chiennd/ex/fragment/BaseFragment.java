package com.chiennd.ex.fragment;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public abstract class BaseFragment extends CoreFragment {

    @LayoutRes
    protected abstract int getLayoutResoure();

    protected abstract void initUI(View rootView);

    protected abstract void bindDataToView();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(getLayoutResoure(), container, false);
        initUI(view);
        return view;
    }
}

package com.ch.nd.fragment;

import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public abstract class BaseFragment extends CoreFragment {

    @LayoutRes
    protected abstract int getLayoutResource();

    protected abstract void initUI(View rootView);

    protected abstract void bindDataToView();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(getLayoutResource(), container, false);
        initUI(view);
        return view;
    }
}

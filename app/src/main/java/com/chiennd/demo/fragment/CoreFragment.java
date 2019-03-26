package com.chiennd.demo.fragment;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModelStore;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chiennd.demo.utility.Constant;
import com.chiennd.demo.utility.Logger;

public abstract class CoreFragment extends Fragment {

    protected abstract String getTagName();

    protected abstract void init();

    @Override
    public Lifecycle getLifecycle() {
        return super.getLifecycle();
    }

    @NonNull
    @Override
    public LifecycleOwner getViewLifecycleOwner() {
        return super.getViewLifecycleOwner();
    }

    @NonNull
    @Override
    public LiveData<LifecycleOwner> getViewLifecycleOwnerLiveData() {
        return super.getViewLifecycleOwnerLiveData();
    }

    @NonNull
    @Override
    public ViewModelStore getViewModelStore() {
        return super.getViewModelStore();
    }

    public CoreFragment() {
        super();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }

    @NonNull
    @Override
    public LayoutInflater onGetLayoutInflater(@Nullable Bundle savedInstanceState) {
        return super.onGetLayoutInflater(savedInstanceState);
    }

    @Override
    public void onInflate(Context context, AttributeSet attrs, Bundle savedInstanceState) {
        super.onInflate(context, attrs, savedInstanceState);
    }


    @Override
    public void onAttachFragment(Fragment childFragment) {
        super.onAttachFragment(childFragment);
        Logger.d(getTagName(), Constant.TypeLogger.LIFECYCLE + " onAttachFragment");
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Logger.d(getTagName(), Constant.TypeLogger.LIFECYCLE + " onAttach");
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init();
        Logger.d(getTagName(), Constant.TypeLogger.LIFECYCLE + " onCreate");
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Logger.d(getTagName(), Constant.TypeLogger.LIFECYCLE + " onCreateView");
        return super.onCreateView(inflater, container, savedInstanceState);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Logger.d(getTagName(), Constant.TypeLogger.LIFECYCLE + " onViewCreated");
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Logger.d(getTagName(), Constant.TypeLogger.LIFECYCLE + "onActivityCreated");
    }

    @Override
    public void onStart() {
        super.onStart();
        Logger.d(getTagName(), Constant.TypeLogger.LIFECYCLE + "onStart");
    }

    @Override
    public void onResume() {
        super.onResume();
        Logger.d(getTagName(), Constant.TypeLogger.LIFECYCLE + "onResume");
    }

    @Override
    public void onPause() {
        super.onPause();
        Logger.d(getTagName(), Constant.TypeLogger.LIFECYCLE + "onPause");
    }

    @Override
    public void onStop() {
        super.onStop();
        Logger.d(getTagName(), Constant.TypeLogger.LIFECYCLE + "onStop");
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        Logger.d(getTagName(), Constant.TypeLogger.LIFECYCLE + "onSaveInstanceState");
    }

    @Override
    public void onViewStateRestored(@Nullable Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
        Logger.d(getTagName(), Constant.TypeLogger.LIFECYCLE + "onViewStateRestored");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Logger.d(getTagName(), Constant.TypeLogger.LIFECYCLE + "onDestroyView");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Logger.d(getTagName(), Constant.TypeLogger.LIFECYCLE + "onDestroy");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Logger.d(getTagName(), Constant.TypeLogger.LIFECYCLE + "onDetach");
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        Logger.d(getTagName(), Constant.TypeLogger.LIFECYCLE + "onLowMemory");
    }

}

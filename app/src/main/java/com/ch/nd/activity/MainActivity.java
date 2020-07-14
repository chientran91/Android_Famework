package com.ch.nd.activity;

import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.widget.TextView;

import androidx.annotation.RequiresApi;

import com.ch.nd.R;
import com.ch.nd.app.CApplication;

import java.io.File;

public class MainActivity extends BaseActivity {
    private TextView tvInfo;

    @Override
    protected String getTag() {
        return MainActivity.class.getSimpleName();
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.activity_main;
    }

    @Override
    protected void initData() {

    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void initView() {
        tvInfo = findViewById(R.id.tv_info);
/*        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.setLength(0);
        stringBuilder.append("getExternalStorageDirectory: ").append(Environment.getExternalStorageDirectory().getAbsolutePath()).append("\n\n")
                .append("getDownloadCacheDirectory : ").append(Environment.getDownloadCacheDirectory()).append("\n\n")
                .append("App getExternalCacheDir : ").append(CApplication.getInstance().getApplicationContext().getExternalCacheDir().getPath()).append("\n\n")
                .append("App getCacheDir : ").append(CApplication.getInstance().getApplicationContext().getCacheDir()).append("\n\n")
                .append("App getFilesDir : ").append(CApplication.getInstance().getApplicationContext().getFilesDir()).append("\n\n")
                .append("App getDataDir : ").append(CApplication.getInstance().getApplicationContext().getDataDir()).append("\n\n")
                .append("App getCodeCacheDir : ").append(CApplication.getInstance().getApplicationContext().getCodeCacheDir()).append("\n\n")
                .append("Environment.DIRECTORY_DOWNLOADS : ").append(CApplication.getInstance().getApplicationContext().getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS)).append(File.separator).append("\n\n");
        tvInfo.setText(stringBuilder.toString());*/

    }


    @Override
    protected void bindDataToView() {

    }
}

package com.ch.nd.activity;

import android.content.res.ColorStateList;
import android.graphics.Paint;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.core.view.ViewCompat;

import com.ch.nd.R;
import com.ch.nd.app.CApplication;
import com.google.android.material.shape.CornerFamily;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.RoundedCornerTreatment;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.shape.ShapePathModel;

import java.io.File;

public class MainActivity extends BaseActivity {
    private TextView tvInfo, textView1;
    private Button button1;
    private ImageView imageView1;

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
        textView1 = findViewById(R.id.textView_1);
        imageView1 = findViewById(R.id.imageView_1);
        button1 = findViewById(R.id.button_1);
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
        float radius = getResources().getDimension(R.dimen.size_8);

       ShapeAppearanceModel shapeAppearanceModel = new ShapeAppearanceModel()
                .toBuilder()
                .setAllCorners(CornerFamily.ROUNDED,radius)
                .build();

        MaterialShapeDrawable shapeDrawable = new MaterialShapeDrawable(shapeAppearanceModel);
        shapeDrawable.setPaintStyle(Paint.Style.FILL_AND_STROKE);
        shapeDrawable.setTint(getResources().getColor(R.color.blue));
        //shapeDrawable.setStrokeWidth((int) getResources().getDimension(R.dimen.size_1));
       // shapeDrawable.setElevation((int) getResources().getDimension(R.dimen.size_4));
       // shapeDrawable.setShadowColor(getResources().getColor(R.color.green));
        shapeDrawable.setTranslationZ((int) getResources().getDimension(R.dimen.size_4));

        MaterialShapeDrawable shapeDrawable2 = new MaterialShapeDrawable(shapeAppearanceModel);
        shapeDrawable2.setPaintStyle(Paint.Style.FILL_AND_STROKE);
        shapeDrawable2.setTint(getResources().getColor(R.color.green));
        //shapeDrawable2.setStrokeWidth((int) getResources().getDimension(R.dimen.size_1));
        // shapeDrawable2.setElevation((int) getResources().getDimension(R.dimen.size_4));
        // shapeDrawable2.setShadowColor(getResources().getColor(R.color.green));
        shapeDrawable2.setTranslationZ((int) getResources().getDimension(R.dimen.size_4));

       /* textView1.setBackground(shapeDrawable);
        button1.setBackground(shapeDrawable);*/
        /*ViewCompat.setBackground(textView1,shapeDrawable);
        ViewCompat.setBackground(button1,shapeDrawable);
        ViewCompat.setBackground(tvInfo,shapeDrawable);
        ViewCompat.setBackground(imageView1,shapeDrawable2);*/
       // tvInfo.setBackground(shapeDrawable);
    }


    @Override
    protected void bindDataToView() {

    }
}

package com.people.activity;

import android.Manifest;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.library.ActivityHelp.PermissionListener;
import com.library.base.BaseActivity;
import com.people.R;

import java.util.List;
import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.functions.Action1;

public class FlashActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flash);
        TextView textView_falsh = (TextView) findViewById(R.id.textView_flash);
        Typeface tf = Typeface.createFromAsset(getAssets(),"font/congti.ttf");
        textView_falsh.setTypeface(tf);
        requestRuntimePermission(new String[]{Manifest.permission.CAMERA}, new PermissionListener() {
            @Override
            public void onGranted() {
                initView();
            }

            @Override
            public void onDenied(List<String> deniedPermission) {
                Toast.makeText(FlashActivity.this, "授权失败", Toast.LENGTH_SHORT).show();
                initView();
            }
        });
    }

    private void initView(){
        Observable.timer(3000, TimeUnit.MILLISECONDS)
                .subscribe(new Action1<Long>() {
                    @Override
                    public void call(Long aLong) {
                        Intent intent = new Intent(FlashActivity.this, ZhihuActivity.class);
                        startActivity(intent);
                        finish();
                    }
                });
    }
}
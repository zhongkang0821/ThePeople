package com.people.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.webkit.WebView;

import com.people.R;

public class WeixinActivity extends AppCompatActivity {

    Toolbar weixintoolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weixin);

        weixintoolbar = (Toolbar) findViewById(R.id.weixintoolbar);
        setToolbar();



        String s = getIntent().getStringExtra("url");
        WebView weixinwv = (WebView) findViewById(R.id.weixinwv);
        weixinwv.loadUrl(s);

    }

    private void setToolbar() {
        weixintoolbar.setTitle("妹子");//设置toolbar的title
        weixintoolbar.setTitleTextColor(Color.WHITE);//toolbar的title字体色
        //设置toolbar返回按钮
        setSupportActionBar(weixintoolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        weixintoolbar.setNavigationOnClickListener(new View.OnClickListener() {//返回的点击监听
            @Override
            public void onClick(View view) {
                onBackPressed();//返回上一页
            }
        });
    }
}

package com.people.activity;

import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.webkit.WebView;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.library.base.BaseActivity;
import com.library.utils.OkHttp;
import com.people.R;
import com.people.bean.DateilsBean;

import java.io.IOException;

import okhttp3.Request;

public class DetailsActivity extends BaseActivity {

    private ImageView detail_img;
    private String urlimg;
    private FloatingActionButton details_fab;

    private CollapsingToolbarLayout collapsingToolbar;
    private WebView webview;
    private String dailydetailsurl = "http://news-at.zhihu.com/api/4/news/";
    int id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        id = getIntent().getIntExtra("idid",1);
        Log.e("ididididiiddididi", id+"" );
        collapsingToolbar = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        detail_img = (ImageView) findViewById(R.id.detail_img);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar1);
        webview = (WebView) findViewById(R.id.webview);
        details_fab = (FloatingActionButton) findViewById(R.id.details_fab);
        toolbar.setNavigationIcon(R.mipmap.icon_up);//设置返回图片
        setSupportActionBar(toolbar);
        getData();

    }

    private void getData() {
        OkHttp.getAsync(dailydetailsurl + id, new OkHttp.DataCallBack() {
            @Override
            public void requestFailure(Request request, IOException e) {

            }

            @Override
            public void requestSuccess(String result) throws Exception {

                final Gson gson = new Gson();
                final DateilsBean mRiBaoDetails = gson.fromJson(result, DateilsBean.class);

                final String share_url = mRiBaoDetails.getShare_url();
                final String image = mRiBaoDetails.getImage();
                final String title = mRiBaoDetails.getTitle();

                DetailsActivity.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Glide.with(DetailsActivity.this).load(image).into(detail_img);
                        webview.loadUrl(share_url);
                        collapsingToolbar.setTitle(title);
                    }
                });
            }
        });
    }

    //返回键
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
        }
        return super.onOptionsItemSelected(item);
    }
}

package com.people.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bigkoo.convenientbanner.CBPageAdapter;
import com.bigkoo.convenientbanner.CBViewHolderCreator;
import com.bigkoo.convenientbanner.ConvenientBanner;
import com.bigkoo.convenientbanner.OnItemClickListener;
import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.library.base.BaseFragment;
import com.library.utils.OkHttp;
import com.people.R;
import com.people.activity.DetailsActivity;
import com.people.adapter.DailyRecyclerAdapter;
import com.people.bean.DailyBean;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Request;

public class DailyOneFragment extends BaseFragment implements  OnItemClickListener {

    private List<Integer> vpimage = new ArrayList<>();
    private List<DailyBean.StoriesBean> dailylist;
    private List<DailyBean.TopStoriesBean> img = new ArrayList<>();
    public static final String daily_url = "http://news-at.zhihu.com/api/4/news/latest";

    private View view;
    private ConvenientBanner daily_vp;
    private RecyclerView dailyrecycler;
    private DailyRecyclerAdapter dailyRecyclerAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.dailyonefragment,container,false);
        daily_vp = (ConvenientBanner) view.findViewById(R.id.daily_vp);
        dailyrecycler = (RecyclerView) view.findViewById(R.id.daily_recycler);
        initData();
        return view;
    }
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }
    private void setRecycler() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setSmoothScrollbarEnabled(true);//设置启用平滑滚动条
        layoutManager.setAutoMeasureEnabled(true);//设置自动测量功能
        dailyrecycler.setLayoutManager(layoutManager);
        dailyrecycler.setHasFixedSize(true);//具有固定大小
        dailyrecycler.setNestedScrollingEnabled(false);
        setDailyRecyclerAdapter();//设置嵌套滚动功能
    }
    private void setDailyRecyclerAdapter() {
        dailyRecyclerAdapter = new DailyRecyclerAdapter(getActivity(),dailylist);
        dailyrecycler.setAdapter(dailyRecyclerAdapter);
        dailyRecyclerAdapter.setmOnItemClickListener(new DailyRecyclerAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, DailyBean.StoriesBean position) {
                Intent dailyintent = new Intent(getActivity(), DetailsActivity.class);
                dailyintent.putExtra("idid",position.getId());
                Log.i("oneon", position.getId()+"");
                startActivity(dailyintent);
            }
        });
    }
    private void initData() {
        dailylist = new ArrayList<>();
        OkHttp.getAsync(daily_url, new OkHttp.DataCallBack() {
            @Override
            public void requestFailure(Request request, IOException e) {
                Toast.makeText(getActivity(), "请求失败", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void requestSuccess(String result) throws Exception {
                Gson gson = new Gson();
                DailyBean dailyBean = gson.fromJson(result,DailyBean.class);

                dailylist = dailyBean.getStories();
                img = dailyBean.getTop_stories();
                iniImg();
                setRecycler();
            }

        });
    }
    private void iniImg() {
        daily_vp.setPages(new CBViewHolderCreator() {
            @Override
            public Object createHolder() {
                return new NetworkImageHolderView();
            }
        },img).setPageTransformer(ConvenientBanner.Transformer.AccordionTransformer).startTurning(2000)
                .setPageIndicator(new int[]{R.drawable.shar,R.drawable.shar2})
                .setOnItemClickListener(this);
    }
    @Override
    public void onItemClick(int position) {
        switch (position) {
            case 0:
                Toast.makeText(getActivity(), "111", Toast.LENGTH_SHORT).show();
                break;
            case 1:
                Toast.makeText(getActivity(), "222", Toast.LENGTH_SHORT).show();
                break;
            case 2:
                Toast.makeText(getActivity(), "333", Toast.LENGTH_SHORT).show();
                break;
            case 3:
                Toast.makeText(getActivity(), "444", Toast.LENGTH_SHORT).show();
                break;
            case 4:
                Toast.makeText(getActivity(), "555", Toast.LENGTH_SHORT).show();
                break;
        }
    }
    public class NetworkImageHolderView implements CBPageAdapter.Holder<DailyBean.TopStoriesBean>{
        private ImageView banner_img;
        private TextView banner_tv;
        @Override
        public View createView(Context context) {
            View view = View.inflate(getActivity(),R.layout.banner_item,null);
            banner_img = (ImageView) view.findViewById(R.id.banner_img);

            banner_tv = (TextView) view.findViewById(R.id.banner_tv);
            banner_img.setScaleType(ImageView.ScaleType.FIT_XY);
            return view;
        }
        @Override
        public void UpdateUI(Context context, int position, DailyBean.TopStoriesBean data) {
            Glide.with(getActivity())
                    .load(data.getImage())
                    .into(banner_img);

            banner_tv.setText(data.getTitle());
        }
    }
}

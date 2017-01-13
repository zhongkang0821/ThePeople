package com.people.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.people.R;
import com.people.activity.WeixinActivity;
import com.people.adapter.WeixinRecyclerAdapter;
import com.people.apputils.RetrofitUtil;
import com.people.bean.WeixinBean;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class WeiXinThreeFragment extends Fragment {

    public static final String weixin_url = "http://api.tianapi.com/";

    private View view;
    private RecyclerView weixinrecycler;
    private List<WeixinBean.NewslistBean> freshweixinList = new ArrayList<>();
    private WeixinRecyclerAdapter weixinAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.weixinthreefragment,container,false);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        weixinrecycler = (RecyclerView) view.findViewById(R.id.weixinrecycler);
        weixinrecycler.setLayoutManager(new LinearLayoutManager(getActivity()));
//        initData();
    }

    @Override
    public void onResume() {
        super.onResume();
        initData();
    }

    private void initData() {
        final Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(weixin_url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RetrofitUtil movieService = retrofit.create(RetrofitUtil.class);
        Call<WeixinBean> call = movieService.getTopMovie("78926886d340296c5125405447aed227",1,20);
        call.enqueue(new Callback<WeixinBean>() {
            @Override
            public void onResponse(Call<WeixinBean> call, Response<WeixinBean> response) {
                freshweixinList.addAll(response.body().getNewslist());
                Toast.makeText(getActivity(), freshweixinList.toString()+"kkkkkkkkkkkkkkkk", Toast.LENGTH_SHORT).show();
                weixinAdapter = new WeixinRecyclerAdapter(getActivity(),freshweixinList);
                weixinrecycler.setAdapter(weixinAdapter);
                weixinAdapter.setmOnItemClickListener(new WeixinRecyclerAdapter.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, WeixinBean.NewslistBean position) {
                        Intent weixinintent = new Intent(getActivity(), WeixinActivity.class);
                        weixinintent.putExtra("url",position.getUrl());
                        startActivity(weixinintent);
                    }
                });
            }

            @Override
            public void onFailure(Call<WeixinBean> call, Throwable t) {
                Toast.makeText(getActivity(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
//        OkHttp.getAsync(weixin_url, new OkHttp.DataCallBack() {
//            @Override
//            public void requestFailure(Request request, IOException e) {
//                Toast.makeText(getActivity(), "请求失败", Toast.LENGTH_SHORT).show();
//            }
//
//            @Override
//            public void requestSuccess(String result) throws Exception {
//                Gson gson = new Gson();
//                WeixinBean weixinBean = gson.fromJson(result,WeixinBean.class);
//                weixinList = weixinBean.getNewslist();
//                freshweixinList.addAll(weixinList);
//                setWeixinAdapter();
//            }
//        });
    }
}

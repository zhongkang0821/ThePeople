package com.people.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.gson.Gson;
import com.library.utils.OkHttp;
import com.people.R;
import com.people.adapter.ColumnRecyclerAdapter;
import com.people.bean.ColumnBean;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Request;

public class ColumnTwoFragment extends Fragment {

    private View view;
    private RecyclerView columnrecycler;
    private List<ColumnBean.DataBean> columnlist;
    private ColumnRecyclerAdapter columnAdapter;
    public static final String columnUrl = "http://news-at.zhihu.com/api/4/sections";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.columntwofragment,container,false);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initData();
        columnrecycler = (RecyclerView) view.findViewById(R.id.columnrecycler);
        columnrecycler.setLayoutManager(new GridLayoutManager(getActivity(),2));
        setColumnAdapter();

    }

    private void setColumnAdapter() {
        columnAdapter = new ColumnRecyclerAdapter(getActivity(),columnlist);
        columnrecycler.setAdapter(columnAdapter);
        columnAdapter.setmOnItemClickListener(new ColumnRecyclerAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Toast.makeText(getActivity(), position + "kkk", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initData() {

        columnlist = new ArrayList<>();

        OkHttp.getAsync(columnUrl, new OkHttp.DataCallBack() {
            @Override
            public void requestFailure(Request request, IOException e) {
                Toast.makeText(getActivity(), "请求失败", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void requestSuccess(String result) throws Exception {
                Gson gson = new Gson();
                ColumnBean columnBean = gson.fromJson(result,ColumnBean.class);
                columnlist = columnBean.getData();
                setColumnAdapter();
            }
        });

    }
}

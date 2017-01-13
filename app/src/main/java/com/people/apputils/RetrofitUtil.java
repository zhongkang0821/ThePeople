package com.people.apputils;

import com.people.bean.WeixinBean;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RetrofitUtil {
    @GET("wxnew")
    Call<WeixinBean> getTopMovie(@Query("key") String key, @Query("num") int num ,@Query("num") int page);

}

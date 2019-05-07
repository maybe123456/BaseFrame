package com.example.administrator.dbtools.sport;


import com.example.administrator.dbtools.base.network.ZResponse;
import com.example.administrator.dbtools.sport.home.bean.ChannerlKey;
import com.example.administrator.dbtools.sport.home.bean.Football;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by Michael on 2018/10/27 19:50 (星期六)
 */
public interface SportService {


    /**
     * 首页title 类型
     */
    @Headers({"BaseUrl:zh"})
    @POST("news/newstypes")
    Call<ZResponse<List<ChannerlKey>>> getSearchKeys();

    /**
     * 首页列表
     */
    @Headers({"BaseUrl:zh"})//@POST("home/Moneyonline/fishlist")
    @POST("news/newslist")
    Call<ZResponse<List<Football>>> getNewsSpotrList(@Query("type") int type, @Query("page") int page, @Query("pageSize") int pageSize);




}

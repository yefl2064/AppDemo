package com.yy.app_a.data.network.api

import com.yy.app_a.data.network.api.Api.Companion.DOUBAN_DOMAIN_NAME
import me.jessyan.retrofiturlmanager.RetrofitUrlManager.DOMAIN_NAME_HEADER
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path


interface DoubanService{

    @Headers(DOMAIN_NAME_HEADER + DOUBAN_DOMAIN_NAME)
    @GET("/v2/book/{id}")
    fun getBook(@Path("id") id: Int): Call<String>

}
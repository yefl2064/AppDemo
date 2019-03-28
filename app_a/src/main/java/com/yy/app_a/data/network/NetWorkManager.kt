package com.yy.app_a.data.network

import android.util.Log
import com.yy.app_a.data.network.api.Api
import com.yy.app_a.data.network.api.DoubanService
import me.jessyan.retrofiturlmanager.RetrofitUrlManager
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import java.util.concurrent.TimeUnit


class NetworkManager private constructor() {

    var loggingInterceptor = HttpLoggingInterceptor(HttpLoggingInterceptor.Logger { message->
        Log.i("RetrofitLog","retrofitBack = "+message);
    }).setLevel(HttpLoggingInterceptor.Level.BODY)

    var mOkHttpClient = RetrofitUrlManager.getInstance().with(OkHttpClient.Builder())
        .readTimeout(5, TimeUnit.SECONDS)
        .connectTimeout(5, TimeUnit.SECONDS)
        .addInterceptor(loggingInterceptor)
        .build()

    var mRetrofit = Retrofit.Builder()
        .baseUrl(Api.APP_DEFAULT_DOMAIN)
        .addConverterFactory(ScalarsConverterFactory.create())
        .addConverterFactory(GsonConverterFactory.create())
        .client(mOkHttpClient)
        .build()

    companion object {
        private var instance: NetworkManager? = null
            get() {
                if (field == null) {
                    field = NetworkManager()
                }
                return field
            }

        @Synchronized
        fun get(): NetworkManager {
            return instance!!
        }
    }

    var mDoubanService = mRetrofit.create<DoubanService>(DoubanService::class.java!!)



}


package com.yy.app_a.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.coolweather.coolweatherjetpack.util.ThreadExecutors
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import com.yy.app_a.data.network.NetworkManager
import com.yy.lib_base.data.Resource


class DoubanRepository private constructor(private val network: NetworkManager){

    companion object {
        private var instance: DoubanRepository? = null

        fun getInstance(network: NetworkManager): DoubanRepository {
            if (instance == null) {
                synchronized(DoubanRepository::class.java) {
                    if (instance == null) {
                        instance =
                            DoubanRepository(network)
                    }
                }
            }
            return instance!!
        }
    }

    fun getBook(id:Int):LiveData<Resource<String>>{
        val liveData = MutableLiveData<Resource<String>>()
        liveData.value = Resource(2, null, null)
        ThreadExecutors.networkIO.execute {
            network.mDoubanService.getBook(id).enqueue(object : Callback<String> {
                override fun onFailure(call: Call<String>, t: Throwable) {
                    liveData.postValue(Resource.error("加载失败", null))
                }
                override fun onResponse(call: Call<String>, response: Response<String>) {
                    var result = response.body()
                    liveData.postValue(Resource.success( result))
                }

            })
        }
        return liveData
    }


}
package com.yy.app_a.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.coolweather.coolweatherjetpack.util.ThreadExecutors
import com.yy.app_a.data.db.UserDao
import com.yy.app_a.data.model.User
import com.yy.app_a.data.network.NetworkManager
import com.yy.lib_base.data.Resource


class UserRepository private constructor(val userDao: UserDao, private val network: NetworkManager){

    companion object {
        private var instance: UserRepository? = null

        fun getInstance(userDao: UserDao, network: NetworkManager): UserRepository {
            if (instance == null) {
                synchronized(UserRepository::class.java) {
                    if (instance == null) {
                        instance =
                            UserRepository(userDao, network)
                    }
                }
            }
            return instance!!
        }
    }

    fun getUsers():LiveData<Resource<List<User>>>{
        val liveData = MutableLiveData<Resource<List<User>>>()
        liveData.value = Resource.loading(null)
        ThreadExecutors.diskIO.execute {
            val list = userDao.getAll()
            if(!list?.isEmpty()){
                ThreadExecutors.mainThread.execute{
                    liveData.value = Resource.success(list)
                }
            }else{
                //network
            }
        }
        return liveData
    }


    fun saveUsers(vararg users:User):LiveData<Resource<List<User>>>{
        val liveData = MutableLiveData<Resource<List<User>>>()
        liveData.value = Resource.loading(null)
        ThreadExecutors.diskIO.execute {
            val state = userDao.insertAll(*users)
            val list = userDao.getAll()
            if(!list?.isEmpty()){
                ThreadExecutors.mainThread.execute{
                    liveData.value = Resource.success(list)
                }

            }else{
                //network
            }
        }
        return liveData
    }


    fun delUser(user:User):LiveData<Resource<List<User>>>{
        val liveData = MutableLiveData<Resource<List<User>>>()
        liveData.value = Resource.loading(null)
        ThreadExecutors.diskIO.execute {
            val state = userDao.delete(user)
            val list = userDao.getAll()
            if(!list?.isEmpty()){
                ThreadExecutors.mainThread.execute{
                    liveData.value = Resource.success(list)
                }
            }else{
                //network
            }
        }
        return liveData
    }


}
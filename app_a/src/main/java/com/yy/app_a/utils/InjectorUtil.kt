package com.yy.app_a.utils

import com.yy.app_a.data.DoubanRepository
import com.yy.app_a.data.UserRepository
import com.yy.app_a.data.db.AppDatabase
import com.yy.app_a.data.network.NetworkManager
import com.yy.ktmes.ui.packingcodecopy.MainFactory
import com.yy.ktmes.ui.packingcodecopy.RoomFactory
import com.yy.lib_base.app.BaseApp

object InjectorUtil {

    private fun getDoubanRepository() = DoubanRepository.getInstance(NetworkManager.get())

    fun getMainFactory() = MainFactory(getDoubanRepository())

    private fun getUserRepository() = UserRepository.getInstance(AppDatabase.getDatabase(BaseApp.getInstance()).userDao(), NetworkManager.get())

    fun getRoomFactory() = RoomFactory(getUserRepository())


}
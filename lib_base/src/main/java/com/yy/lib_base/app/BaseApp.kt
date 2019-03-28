package com.yy.lib_base.app

import android.app.Activity
import android.app.Application
import android.content.Context
import android.os.Bundle
import androidx.multidex.MultiDex
import com.alibaba.android.arouter.launcher.ARouter
import com.yy.lib_base.config.ModuleConfig
import com.yy.lib_base.util.AcitivityManager
import com.yy.lib_base.util.MyUtil
import me.jessyan.autosize.AutoSize

open class BaseApp:Application(){

    companion object {
        @Volatile private var INSTANCE: BaseApp? = null
        fun getInstance(): BaseApp =
            INSTANCE ?: synchronized(this) {
                INSTANCE ?:BaseApp()
            }
    }

    override fun onCreate() {
        super.onCreate()
        initModuleConfig()
        registerActivityLifecycleCallbacks(lifecycleCallbacks)
        AutoSize.initCompatMultiProcess(this)
        initRoute()

    }

    fun initRoute(){
        ARouter.openLog()
        ARouter.openDebug()
        ARouter.init(this)
    }


    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        MultiDex.install(base)
    }



    override fun onTerminate() {
        super.onTerminate()
        ARouter.getInstance().destroy()
    }


    fun initModuleConfig(){
        for (modules in ModuleConfig.MODULESLIST){
            try {
                val clz = Class.forName(modules)
                val obj = clz.newInstance()
                if (obj is IApplicationLike){
                    obj.onCreate(this)
                }
            } catch (e:Exception) {
                e.printStackTrace()
            }
        }
    }





    /**
     * 以下为防止短时间内两次点击button
     */
    private val lifecycleCallbacks = object : ActivityLifecycleCallbacks{
        override fun onActivityCreated(activity: Activity, bundle: Bundle?) {
            MyUtil.fixViewMutiClickInShortTime(activity)
            AcitivityManager.instance.addActivity(activity)
        }

        override fun onActivityStarted(activity: Activity) {

        }

        override fun onActivityResumed(activity: Activity) {

        }

        override fun onActivityPaused(activity: Activity) {

        }

        override fun onActivityStopped(activity: Activity) {

        }

        override fun onActivitySaveInstanceState(activity: Activity, bundle: Bundle?) {

        }

        override fun onActivityDestroyed(activity: Activity) {
            AcitivityManager.instance.removeActivity(activity)
        }
    }

}
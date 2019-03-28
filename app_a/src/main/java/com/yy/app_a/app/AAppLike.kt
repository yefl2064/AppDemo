package com.yy.app_a.app

import com.yy.app_a.data.db.AppDatabase
import com.yy.app_a.data.network.api.Api
import com.yy.lib_base.app.BaseApp
import com.yy.lib_base.app.IApplicationLike
import me.jessyan.retrofiturlmanager.RetrofitUrlManager

class AAppLike:IApplicationLike{

    override fun onCreate(app: BaseApp) {
        RetrofitUrlManager.getInstance().putDomain(Api.GITHUB_DOMAIN_NAME, Api.APP_GITHUB_DOMAIN)
        RetrofitUrlManager.getInstance().putDomain(Api.DOUBAN_DOMAIN_NAME, Api.APP_DOUBAN_DOMAIN)
        AppDatabase.getDatabase(app)
    }

    override fun onStop() {

    }

}
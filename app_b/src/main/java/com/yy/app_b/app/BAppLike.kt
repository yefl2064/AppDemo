package com.yy.app_b.app

import com.alibaba.android.arouter.launcher.ARouter
import com.yy.lib_base.app.BaseApp
import com.yy.lib_base.app.IApplicationLike

class BAppLike:IApplicationLike{

    override fun onCreate(app: BaseApp) {
        ARouter.openLog()
        ARouter.openDebug()
        ARouter.init(app)
    }

    override fun onStop() {

    }

}
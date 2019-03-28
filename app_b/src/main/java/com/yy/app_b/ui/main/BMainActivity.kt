package com.yy.app_b.ui.main

import android.content.Context
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.yy.app_b.R
import com.yy.lib_base.app.RouteHub
import com.yy.lib_base.base.BaseActivity
import com.yy.service.module_a.AService
import kotlinx.android.synthetic.main.activity_b_main.*
import kotlinx.android.synthetic.main.b_title_layout.*

@Route(path=RouteHub.B_MAIN)
class BMainActivity : BaseActivity() {
    override fun getAct(): Context {
        return this
    }

    override fun getContentView(): Int {
        return R.layout.activity_b_main
    }

    override fun initView() {
        topbar.setTitle("Module B")
        btn_to_a.setOnClickListener {
            ARouter.getInstance().build(RouteHub.A_MAIN).navigation()
        }

        val impl = ARouter.getInstance().build(RouteHub.A_Service).navigation() as AService
        tv.append(impl.getAddress().toString())

    }

    override fun initData() {
    }



}

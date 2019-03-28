package com.yy.appdemo.ui.main

import android.content.Context
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.yy.appdemo.R
import com.yy.lib_base.app.RouteHub
import com.yy.lib_base.base.BaseActivity
import com.yy.service.module_a.AService
import kotlinx.android.synthetic.main.activity_main.*

@Route(path=RouteHub.M_MAIN)
class MainActivity : BaseActivity() {


    override fun getAct(): Context {
        return this
    }

    override fun getContentView(): Int {
        return R.layout.activity_main
    }

    override fun initView() {
        val impl = ARouter.getInstance().build(RouteHub.A_Service).navigation() as AService
        tv.text = impl.getAddress().toString()

        btn_to_a.setOnClickListener { ARouter.getInstance().build(RouteHub.A_MAIN).navigation() }
        btn_to_b.setOnClickListener { ARouter.getInstance().build(RouteHub.B_MAIN).navigation() }
    }

    override fun initData() {

    }

}

package com.yy.app_a.ui.main

import android.content.Context
import androidx.lifecycle.ViewModelProviders
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.yy.app_a.R
import com.yy.app_a.app.GlideApp
import com.yy.app_a.utils.InjectorUtil
import com.yy.lib_base.app.RouteHub
import com.yy.lib_base.base.BaseActivity
import kotlinx.android.synthetic.main.a_title_layout.*
import kotlinx.android.synthetic.main.main_activity.*

@Route(path = RouteHub.A_MAIN)
class AMainActivity : BaseActivity() {

    lateinit var mainViewModel: MainViewModel

    override fun getAct(): Context {
        return this
    }

    override fun getContentView(): Int {
        return R.layout.main_activity
    }

    override fun initView() {
        topbar.setTitle("标题")
        btn_room.setOnClickListener {
            ARouter.getInstance().build(RouteHub.A_ROOM).navigation()
        }
        btn_net.setOnClickListener {
            handleData(mainViewModel.getBook(1)){it
                tv_info.text = it
            }
        }

        btn_work.setOnClickListener { ARouter.getInstance().build(RouteHub.A_WORK).navigation() }
        btn_to_b.setOnClickListener { ARouter.getInstance().build(RouteHub.B_MAIN).navigation()  }

        mainViewModel = ViewModelProviders.of(this, InjectorUtil.getMainFactory()).get(MainViewModel::class.java)
        GlideApp.with(getAct()).load("https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=2150681981,1079538934&fm=27&gp=0.jpg").into(imageview)

    }

    override fun initData() {

    }


}

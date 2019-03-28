package com.yy.app_a.ui.work

import android.content.Context
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import com.alibaba.android.arouter.facade.annotation.Route
import com.yy.app_a.R
import com.yy.lib_base.app.RouteHub
import com.yy.lib_base.base.BaseActivity
import kotlinx.android.synthetic.main.a_title_layout.*

@Route(path=RouteHub.A_WORK)
class WorkActivity : BaseActivity() {
    override fun getContentView(): Int {
        return R.layout.work_activity
    }

    override fun initView() {
        topbar.setTitle("work")
        topbar.addLeftBackImageButton().setOnClickListener { finish() }
    }

    override fun initData() {
        val workRequest = OneTimeWorkRequestBuilder<Work1>().build()
        WorkManager.getInstance().enqueue(workRequest)
    }

    override fun getAct(): Context {
        return this
    }


}

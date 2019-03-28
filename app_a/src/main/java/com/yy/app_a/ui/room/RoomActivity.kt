package com.yy.app_a.ui.room

import android.content.Context
import androidx.lifecycle.ViewModelProviders
import com.alibaba.android.arouter.facade.annotation.Route
import com.google.gson.Gson
import com.yy.app_a.R
import com.yy.app_a.data.model.User
import com.yy.app_a.utils.InjectorUtil
import com.yy.lib_base.app.RouteHub
import com.yy.lib_base.base.BaseActivity
import kotlinx.android.synthetic.main.a_title_layout.*
import kotlinx.android.synthetic.main.room_activity.*


@Route(path = RouteHub.A_ROOM)
class RoomActivity : BaseActivity() {

    lateinit var mRoomViewModel: RoomViewModel

    override fun getAct(): Context {
        return this
    }

    override fun getContentView(): Int {
        return R.layout.room_activity
    }

    override fun initView() {
        topbar.setTitle("database")
        topbar.addLeftBackImageButton().setOnClickListener { finish() }
        btn_save.setOnClickListener { save() }
        btn_query.setOnClickListener {  query() }
        btn_delete.setOnClickListener { del() }
        mRoomViewModel = ViewModelProviders.of(this, InjectorUtil.getRoomFactory()).get(RoomViewModel::class.java)
    }

    override fun initData() {

    }

    fun save(){
        val user1 = User(0,"張三","san")
        val user2= User(1,"李四3","li")
        handleData(mRoomViewModel.saveUsers(user1,user2)){ result->
            tv_info.text = Gson().toJson(result)
        }
    }

    fun query(){
        handleData(mRoomViewModel.getUsers()){ result->
            tv_info.text = Gson().toJson(result)
        }
    }

    fun del(){
        val user1 = User(1,"22","")
        handleData(mRoomViewModel.saveUsers(user1)){ result->
            tv_info.text = Gson().toJson(result)
        }
    }
}

package com.yy.app_a.service

import android.content.Context
import com.alibaba.android.arouter.facade.annotation.Route
import com.yy.lib_base.app.RouteHub
import com.yy.service.module_a.entity.Address
import com.yy.service.module_a.AService

@Route(path = RouteHub.A_Service)
class AServiceImpl: AService {
    override fun getAddress(): Address {
        return Address("福建","厦门")
    }


    override fun init(context: Context?) {

    }

}
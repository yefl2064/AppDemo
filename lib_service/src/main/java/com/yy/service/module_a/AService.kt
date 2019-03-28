package com.yy.service.module_a

import com.alibaba.android.arouter.facade.template.IProvider
import com.yy.service.module_a.entity.Address

interface AService:IProvider {
    fun getAddress():Address
}
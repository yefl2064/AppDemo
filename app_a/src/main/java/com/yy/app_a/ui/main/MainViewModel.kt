package com.yy.app_a.ui.main

import androidx.lifecycle.ViewModel
import com.yy.app_a.data.DoubanRepository

class MainViewModel(val response: DoubanRepository) : ViewModel() {

    fun getBook(id:Int) = response.getBook(id)
}

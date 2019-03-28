package com.yy.ktmes.ui.packingcodecopy

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.yy.app_a.data.DoubanRepository
import com.yy.app_a.ui.main.MainViewModel

class MainFactory(private val repository: DoubanRepository): ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MainViewModel(repository) as T
    }
}

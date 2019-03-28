package com.yy.ktmes.ui.packingcodecopy

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.yy.app_a.data.UserRepository
import com.yy.app_a.ui.room.RoomViewModel

class RoomFactory(private val repository: UserRepository): ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return RoomViewModel(repository) as T
    }
}

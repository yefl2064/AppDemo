package com.yy.app_a.ui.room

import androidx.lifecycle.ViewModel
import com.yy.app_a.data.UserRepository
import com.yy.app_a.data.model.User

class RoomViewModel(private val repository: UserRepository) : ViewModel() {

    fun getUsers()=repository.getUsers()

    fun saveUsers(vararg users: User) = repository.saveUsers(*users)

    fun saveUsers(user: User) = repository.delUser(user)
}

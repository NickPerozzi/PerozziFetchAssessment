package com.shure.perozzifetchassessment.homescreen

import androidx.lifecycle.ViewModel
import com.shure.perozzifetchassessment.model.User

class HomeScreenViewModel : ViewModel() {
    val userData: List<User> = listOf(
        User(1, 2, "first user"),
        User(3, 4, "second user")
    )
}
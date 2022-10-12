package com.shure.perozzifetchassessment.homescreen

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.shure.perozzifetchassessment.model.User
import com.shure.perozzifetchassessment.repositories.userdata.UserDataRepository
import kotlinx.coroutines.launch

class HomeScreenViewModel : ViewModel() {

    private var fetchedUserData: List<User>? = null
    var presentedUserData: MutableList<User> = mutableListOf()
    var userDataStatus: MutableState<String> = mutableStateOf("Initial")

    private fun fetchUserData() {
        viewModelScope.launch {
            if (userDataStatus.value == "Initial") {
                fetchedUserData = UserDataRepository.getUserData()
                when (fetchedUserData) {
                    null -> userDataStatus.value = "Null"
                    else -> userDataStatus.value = "Fetched"
                }
            }
        }
    }

    private fun filterPresentedUserData() {
        val mutableList: MutableList<User> = mutableListOf()
        fetchedUserData?.let {
            for (user in it) {
                if (user.name != null && user.name != "") {
                    mutableList.add(user)
                }
            }
            presentedUserData = mutableList
        }
    }

    private fun sortPresentedUserData() {
        val mutableList: MutableList<User> = presentedUserData
        fetchedUserData?.let {
            presentedUserData = mutableList.sortedWith(compareBy(
                { it.listId },
                { it.name }
            )) as MutableList<User>
        }
    }

    fun addZerosToNumberInString(str: String): String {
        return when (str.length) {
            6 -> StringBuilder(str).insert(str.length - 1, "00").toString()
            else -> StringBuilder(str).insert(str.length - 2, "0").toString()
        }
    }

    fun removeZerosFromNumberInString(str: String): String {
        return when (str[str.length-2]) {
            '0' -> StringBuilder(str).removeRange(str.length - 3, str.length - 1).toString()
            else -> StringBuilder(str).removeRange(str.length - 3, str.length - 2).toString()
        }
    }

    fun gatherUserData() {
        fetchUserData()
        if (fetchedUserData != null && userDataStatus.value == "Fetched") {
            filterPresentedUserData()
            for (user in presentedUserData) {
                if (user.name != null) {
                    if (user.name!!.length == 6 || user.name!!.length == 7) {
                        user.name = addZerosToNumberInString(user.name!!)
                    }
                }
            }
            sortPresentedUserData()
            for (user in presentedUserData) {
                if (user.name != null) {
                    if (user.name!![user.name!!.length-3] == '0') {
                        user.name = removeZerosFromNumberInString(user.name!!)
                    }
                }
            }
            userDataStatus.value = "Filtered and sorted"
        }
    }
}
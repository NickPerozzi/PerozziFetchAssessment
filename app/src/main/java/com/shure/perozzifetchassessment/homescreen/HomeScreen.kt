package com.shure.perozzifetchassessment.homescreen

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import com.shure.perozzifetchassessment.homescreen.HomeScreenViewModel
import com.shure.perozzifetchassessment.ui.components.UserBlock

val viewModel = HomeScreenViewModel()

@Composable
fun HomeScreen() {
    LazyColumn {
        itemsIndexed(
            viewModel.userData
        ) { _, user ->
            UserBlock(listId = user.listId, name = user.name)
        }
    }
}
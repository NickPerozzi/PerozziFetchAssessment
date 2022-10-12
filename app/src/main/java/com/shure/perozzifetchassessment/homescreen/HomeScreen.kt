package com.shure.perozzifetchassessment.homescreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.MaterialTheme.colors
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import com.shure.perozzifetchassessment.R
import com.shure.perozzifetchassessment.model.User
import com.shure.perozzifetchassessment.ui.components.LoadingBlock
import com.shure.perozzifetchassessment.ui.components.UserBlock
import com.shure.perozzifetchassessment.ui.theme.Dimensions
import com.shure.perozzifetchassessment.ui.theme.PerozziFetchAssessmentTheme

val model: HomeScreenViewModel = HomeScreenViewModel()

@Composable
fun HomeScreen(
    connectedState: MutableState<String> = model.userDataStatus,
) {
    model.gatherUserData()
    val users: List<User> = model.presentedUserData
    PerozziFetchAssessmentTheme {
        Box(
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth()
                .background(colors.background)
        ) {
            Column {
                Text(
                    modifier = Modifier.padding(Dimensions.paddingSmall),
                    text = stringResource(id = R.string.home_screen_title),
                    textAlign = TextAlign.Center,
                    color = colors.onBackground
                )
                if (connectedState.value == "Initial") {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .fillMaxHeight(),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        LoadingBlock()
                    }
                }
                if (connectedState.value == "Filtered and sorted") {
                    LazyColumn(
                        modifier = Modifier.padding(Dimensions.padding)
                    ) {
                        itemsIndexed(
                            users
                        ) { _, user ->
                            UserBlock(
                                modifier = Modifier
                                    .padding(Dimensions.paddingSmall)
                                    .fillMaxWidth(),
                                listId = user.listId,
                                name = user.name ?: "No username"
                            )
                        }
                    }
                }
            }
            if (connectedState.value == "Null") {
                Text(
                    modifier = Modifier
                        .align(Alignment.Center)
                        .padding(Dimensions.paddingSmall),
                    textAlign = TextAlign.Center,
                    text = stringResource(id = R.string.no_connection_no_users),
                    fontSize = Dimensions.listPlaceholderFontSize,
                    color = colors.onBackground
                )
            }
        }
    }
}
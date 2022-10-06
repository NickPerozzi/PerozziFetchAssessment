package com.shure.perozzifetchassessment.ui.components

import android.content.res.Resources
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.MaterialTheme.colors
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.shure.perozzifetchassessment.R
import com.shure.perozzifetchassessment.ui.theme.Dimensions
import com.shure.perozzifetchassessment.ui.theme.PerozziFetchAssessmentTheme
import com.shure.perozzifetchassessment.ui.theme.Typography

@Composable
fun UserBlock(
    modifier: Modifier = Modifier,
    listId: Int,
    name: String?,
    onClick: () -> Unit = {},
) {
    PerozziFetchAssessmentTheme {
        Card(
            modifier = modifier.clickable { onClick() },
            elevation = Dimensions.blockElevation,
            backgroundColor = colors.surface
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    modifier = Modifier
                        .padding(
                            top = Dimensions.padding,
                            bottom = Dimensions.padding,
                            start = Dimensions.padding
                        )
                        .size(Dimensions.iconSize),
                    imageVector = Icons.Default.Person,
                    tint = colors.primary,
                    contentDescription = "Placeholder Profile"
                )
                Column(
                    modifier = Modifier.padding(Dimensions.padding),
                    verticalArrangement = Arrangement.SpaceAround
                ) {
                    Text(
                        style = MaterialTheme.typography.body1,
                        fontWeight = FontWeight.Thin,
                        text = Resources.getSystem().getString(R.string.id_number, listId.toString())
                    )
                    Text(
                        style = Typography.body2,
                        text = Resources.getSystem().getString(R.string.name, name),
                        color = colors.primary
                    )
                }
            }
        }

    }
}

@Preview
@Composable
fun UserBlockPreview() {
    Column(
        modifier = Modifier
            .height(130.dp)
            .background(colors.background),
        verticalArrangement = Arrangement.SpaceAround
    ) {
        UserBlock(
            listId = 68,
            name = "Sample name 001"
        )
        UserBlock(
            listId = 70,
            name = "Sample name 002"
        )
    }
}

package com.shure.perozzifetchassessment.ui.components

import androidx.compose.material.MaterialTheme.colors
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import com.shure.perozzifetchassessment.R
import com.shure.perozzifetchassessment.ui.theme.Dimensions
import com.shure.perozzifetchassessment.ui.theme.PerozziFetchAssessmentTheme

@Composable
fun LoadingBlock(modifier: Modifier = Modifier) {
    PerozziFetchAssessmentTheme {
        Text(
            modifier = modifier,
            color = colors.onBackground,
            text = stringResource(id = R.string.loading),
            textAlign = TextAlign.Center,
            fontSize = Dimensions.listPlaceholderFontSize
        )
    }
}
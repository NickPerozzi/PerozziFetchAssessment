package com.shure.perozzifetchassessment

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.shure.perozzifetchassessment.homescreen.HomeScreen
import com.shure.perozzifetchassessment.ui.theme.PerozziFetchAssessmentTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PerozziFetchAssessmentTheme {
                HomeScreen()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    PerozziFetchAssessmentTheme {
        HomeScreen()
    }
}
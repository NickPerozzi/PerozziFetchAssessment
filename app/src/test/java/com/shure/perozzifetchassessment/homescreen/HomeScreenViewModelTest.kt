package com.shure.perozzifetchassessment.homescreen

import org.junit.After
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test

class HomeScreenViewModelTest {

    private lateinit var model: HomeScreenViewModel

    @Before
    fun setup() {
        model = HomeScreenViewModel()
    }

    @Test
    fun `insert username with extra zeros, returns without zeros`() {
        assertTrue(model.removeZerosFromNumberInString("Item 005") == "Item 5")
        assertTrue(model.removeZerosFromNumberInString("Item 064") == "Item 64")
    }

    @Test
    fun `insert username without zeros, returns with extra zeros`() {
        assertTrue(model.addZerosToNumberInString("Item 5") == "Item 005")
        assertTrue(model.addZerosToNumberInString("Item 64") == "Item 064")
    }

    @After
    fun teardown() {
        // nothing backend-related to tear down
    }
}
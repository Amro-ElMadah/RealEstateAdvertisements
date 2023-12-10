package com.avivgroup.realestateadvertisements

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.avivgroup.realestateadvertisements.ui.main.presentation.view.screens.EmptyListScreen
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class EmptyListScreenTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun loadEmptyListScreenDisplayedCorrectly() {
        composeTestRule.setContent {
            EmptyListScreen()
        }

        composeTestRule.onNodeWithText("There's no real estates at the moment, please try again later").assertExists()
    }
}
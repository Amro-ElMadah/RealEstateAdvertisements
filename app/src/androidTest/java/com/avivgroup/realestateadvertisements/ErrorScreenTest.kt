package com.avivgroup.realestateadvertisements

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.avivgroup.realestateadvertisements.ui.main.presentation.view.screens.ErrorScreen
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class ErrorScreenTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun loadErrorScreenDisplayedCorrectly() {
        val error = "Fake error"
        composeTestRule.setContent {
            ErrorScreen(error = error) {}
        }

        composeTestRule.onNodeWithText(error).assertExists()
        composeTestRule.onNodeWithText("Retry").assertExists()
    }
}
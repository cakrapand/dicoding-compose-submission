package com.example.got.ui.components

import androidx.activity.ComponentActivity
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onRoot
import androidx.compose.ui.test.printToLog
import com.example.got.ui.theme.GOTTheme
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class AboutContentTest{
    @get:Rule
    val composeTestRule = createAndroidComposeRule<ComponentActivity>()

    @Before
    fun setUp() {
        composeTestRule.setContent {
            GOTTheme() {
                AboutContent(onBackClick = {})
            }
        }
        composeTestRule.onRoot().printToLog("currentLabelExists")
    }

    @Test
    fun aboutContent_isDisplayed() {
        composeTestRule.onNodeWithTag("About Me").assertIsDisplayed()
    }
}
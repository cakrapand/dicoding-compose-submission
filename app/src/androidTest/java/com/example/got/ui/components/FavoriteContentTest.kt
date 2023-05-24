package com.example.got.ui.components

import androidx.activity.ComponentActivity
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.onRoot
import androidx.compose.ui.test.printToLog
import com.example.got.model.FakeDataSource
import com.example.got.ui.theme.GOTTheme
import com.example.got.R
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class FavoriteContentTest{
    @get:Rule
    val composeTestRule = createAndroidComposeRule<ComponentActivity>()
    private val fakeFavorite = FakeDataSource.dummyCharacters

    @Before
    fun setUp() {
        composeTestRule.setContent {
            GOTTheme() {
                FavoriteContent(
                    favoriteCharacters = fakeFavorite,
                    navigateToDetail = {},
                    onBackClick = {}
                )
            }
        }
        composeTestRule.onRoot().printToLog("currentLabelExists")
    }

    @Test
    fun favoriteContent_isDisplayed() {
        composeTestRule.onNodeWithTag("Favorite List").assertIsDisplayed()
    }
}
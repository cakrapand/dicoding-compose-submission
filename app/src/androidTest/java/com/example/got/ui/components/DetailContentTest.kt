package com.example.got.ui.components

import androidx.activity.ComponentActivity
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.onRoot
import androidx.compose.ui.test.printToLog
import com.example.got.R
import com.example.got.model.FakeDataSource
import com.example.got.ui.theme.GOTTheme
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class DetailContentTest{
    @get:Rule
    val composeTestRule = createAndroidComposeRule<ComponentActivity>()
    private val fakeCharacter = FakeDataSource.dummyCharacters[0]
    private val fakeIsFavorite = true


    @Before
    fun setUp() {
        composeTestRule.setContent {
            GOTTheme {
                DetailContent(
                    character = fakeCharacter,
                    isFavorite = fakeIsFavorite,
                    addToFavorite = {},
                    deleteFromFavorite = {},
                    onBackClick = {}
                )
            }
        }
        composeTestRule.onRoot().printToLog("currentLabelExists")
    }

    @Test
    fun detailContent_isDisplayed() {
        composeTestRule.onNodeWithText(composeTestRule.activity.getString(R.string.name, fakeCharacter.name)).assertIsDisplayed()
        composeTestRule.onNodeWithText(composeTestRule.activity.getString(R.string.alias, fakeCharacter.alias)).assertIsDisplayed()
        composeTestRule.onNodeWithText(composeTestRule.activity.getString(R.string.cast, fakeCharacter.cast)).assertIsDisplayed()
        composeTestRule.onNodeWithText(composeTestRule.activity.getString(R.string.gender, fakeCharacter.gender)).assertIsDisplayed()
        composeTestRule.onNodeWithText(composeTestRule.activity.getString(R.string.house, fakeCharacter.house)).assertIsDisplayed()
        composeTestRule.onNodeWithText(fakeCharacter.detail).assertIsDisplayed()
        composeTestRule.onNodeWithContentDescription("Favorite Button").assertIsDisplayed()
    }
}
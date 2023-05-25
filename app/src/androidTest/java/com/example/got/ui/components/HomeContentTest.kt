package com.example.got.ui.components

import androidx.activity.ComponentActivity
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.onRoot
import androidx.compose.ui.test.performTextInput
import androidx.compose.ui.test.printToLog
import com.example.got.model.FakeDataSource
import com.example.got.ui.theme.GOTTheme
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class HomeContentTest{
    @get:Rule
    val composeTestRule = createAndroidComposeRule<ComponentActivity>()
    private val dummyCharacters = FakeDataSource.dummyCharacters.sortedBy { it.name }.groupBy { it.house }
    private val dummyQuery = "Stark"

    @Before
    fun setUp() {
        composeTestRule.setContent {
            GOTTheme() {
                HomeContent(
                    groupedCharacters = dummyCharacters,
                    query = "",
                    onQueryChange = {},
                    navigateToAbout = {},
                    navigateToDetail = {},
                    navigateToFavorite = { },
                )
            }
        }
        composeTestRule.onRoot().printToLog("currentLabelExists")
    }

    @Test
    fun homeContent_isDisplayed() {
        composeTestRule.onNodeWithTag("CharacterList").assertIsDisplayed()
        composeTestRule.onNodeWithText(FakeDataSource.dummyCharacters[4].name).assertIsDisplayed()
        composeTestRule.onNodeWithContentDescription("about_page").assertIsDisplayed()
        composeTestRule.onNodeWithContentDescription("favorite_page").assertIsDisplayed()
        composeTestRule.onNodeWithTag("SearchBar").assertIsDisplayed()
    }

    @Test
    fun testSearch() {
        composeTestRule.onNodeWithTag("SearchBar").assertIsDisplayed()
        composeTestRule.onNodeWithTag("SearchBar").performTextInput(dummyQuery)
    }
}
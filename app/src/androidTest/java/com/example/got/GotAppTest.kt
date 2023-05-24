package com.example.got

import androidx.activity.ComponentActivity
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performScrollToIndex
import androidx.navigation.compose.ComposeNavigator
import androidx.navigation.testing.TestNavHostController
import com.example.got.model.FakeDataSource
import com.example.got.ui.navigation.Screen
import com.example.got.ui.theme.GOTTheme
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class GotAppTest {
    @get:Rule
    val composeTestRule = createAndroidComposeRule<ComponentActivity>()
    private lateinit var navController: TestNavHostController

    @Before
    fun setUp() {
        composeTestRule.setContent {
            GOTTheme {
                navController = TestNavHostController(LocalContext.current)
                navController.navigatorProvider.addNavigator(ComposeNavigator())
                GotApp(navController = navController)
            }
        }
    }

    @Test
    fun navHost_verifyStartDestination() {
        navController.assertCurrentRouteName(Screen.Home.route)
    }

    @Test
    fun navHost_clickItem_navigatesToDetailWithData() {
        composeTestRule.onNodeWithTag("CharacterList").performScrollToIndex(4)
        composeTestRule.onNodeWithText(FakeDataSource.dummyCharacters[4].name).performClick()
        navController.assertCurrentRouteName(Screen.Detail.route)
        composeTestRule.onNodeWithText(composeTestRule.activity.getString(R.string.name, FakeDataSource.dummyCharacters[4].name)).assertIsDisplayed()
    }

    @Test
    fun navHost_navigatesToAbout() {
        composeTestRule.onNodeWithContentDescription("about_page").performClick()
        navController.assertCurrentRouteName(Screen.About.route)
        composeTestRule.onNodeWithText(composeTestRule.activity.getString(R.string.about_name)).assertIsDisplayed()
    }

    @Test
    fun navHost_navigatesToFavorite() {
        composeTestRule.onNodeWithContentDescription("favorite_page").performClick()
        navController.assertCurrentRouteName(Screen.Favorite.route)
        composeTestRule.onNodeWithTag("Favorite List")
    }

    @Test
    fun testAddFavourite() {
        composeTestRule.onNodeWithText(FakeDataSource.dummyCharacters[4].name).performClick()
        navController.assertCurrentRouteName(Screen.Detail.route)
        composeTestRule.onNodeWithText(composeTestRule.activity.getString(R.string.name, FakeDataSource.dummyCharacters[4].name)).assertIsDisplayed()
        composeTestRule.onNodeWithContentDescription("Favorite Button").performClick()
        composeTestRule.onNodeWithContentDescription(composeTestRule.activity.getString(R.string.navigation_back)).performClick()
        navController.assertCurrentRouteName(Screen.Home.route)
        composeTestRule.onNodeWithContentDescription("favorite_page").assertIsDisplayed()
        composeTestRule.onNodeWithContentDescription("favorite_page").performClick()
        navController.assertCurrentRouteName(Screen.Favorite.route)
        composeTestRule.onNodeWithText(FakeDataSource.dummyCharacters[4].name).assertIsDisplayed()
    }

    @Test
    fun testDeleteFavourite() {
        composeTestRule.onNodeWithContentDescription("favorite_page").assertIsDisplayed()
        composeTestRule.onNodeWithContentDescription("favorite_page").performClick()
        navController.assertCurrentRouteName(Screen.Favorite.route)
        composeTestRule.onNodeWithTag("Favorite List").assertIsDisplayed()
        composeTestRule.onNodeWithText(FakeDataSource.dummyCharacters[4].name).performClick()
        navController.assertCurrentRouteName(Screen.Detail.route)
        composeTestRule.onNodeWithContentDescription("Favorite Button").performClick()
    }
}
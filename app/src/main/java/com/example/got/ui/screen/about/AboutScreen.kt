package com.example.got.ui.screen.about

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.got.ui.components.AboutContent

@Composable
fun AboutScreen(
    modifier: Modifier = Modifier,
    navigateBack: () -> Unit)
{
    AboutContent(modifier = modifier, onBackClick = navigateBack)
}
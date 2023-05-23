package com.example.got.ui.components

import androidx.compose.foundation.layout.Row
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import com.example.got.ui.theme.GOTTheme

@Composable
fun OptionMenu(
    navigateToAbout: () -> Unit,
    navigateToFavorite: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(modifier = modifier) {
        IconButton(onClick = navigateToFavorite) {
            Icon(Icons.Default.Favorite, "Favorite Character")
        }

        IconButton(onClick = navigateToAbout) {
            Icon(Icons.Default.Person, "about_page")
        }
    }
}

@Preview(showBackground = true, device = Devices.PIXEL_4)
@Composable
fun OptionMenuPreview() {
    GOTTheme {
        OptionMenu(navigateToAbout = {}, navigateToFavorite = {})
    }
}
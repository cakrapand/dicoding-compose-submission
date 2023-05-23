package com.example.got.ui.screen.about

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import com.example.got.R
import com.example.got.ui.theme.GOTTheme

@Composable
fun AboutScreen(modifier: Modifier = Modifier) {
    Column(modifier = modifier, horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = stringResource(R.string.about_me))
        Image(
            painter = painterResource(id = R.drawable.cakra),
            contentDescription = stringResource(R.string.about_name)
        )
        Text(text = stringResource(R.string.about_name))
        Text(text = stringResource(R.string.about_email))

    }
}

@Preview(showBackground = true, device = Devices.PIXEL_4)
@Composable
fun AboutScreenPreview() {
    GOTTheme {
        AboutScreen()
    }
}
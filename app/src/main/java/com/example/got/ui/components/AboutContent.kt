package com.example.got.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ShapeDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.got.R

@Composable
fun AboutContent(
    modifier: Modifier = Modifier,
    onBackClick: () -> Unit,
) {
    Column( modifier = modifier.verticalScroll(rememberScrollState())) {
        Icon(
            imageVector = Icons.Default.ArrowBack,
            contentDescription = stringResource(R.string.navigation_back),
            modifier = Modifier
                .padding(16.dp)
                .clickable {onBackClick() }
        )
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(vertical = 100.dp)
                .testTag("About Me"),
            horizontalAlignment = Alignment.CenterHorizontally) {
            Text(
                text = stringResource(R.string.about_me),
                style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.ExtraBold)
            )
            Spacer(modifier = modifier.padding(10.dp))
            Image(
                painter = painterResource(id = R.drawable.cakra),
                contentDescription = stringResource(R.string.about_name),
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(200.dp)
                    .clip(ShapeDefaults.Medium)
            )
            Spacer(modifier = modifier.padding(5.dp))
            Text(
                text = stringResource(R.string.about_email),
                style = MaterialTheme.typography.bodyLarge
            )
            Text(
                text = stringResource(R.string.about_name),
                style = MaterialTheme.typography.bodyLarge
            )
        }
    }

}
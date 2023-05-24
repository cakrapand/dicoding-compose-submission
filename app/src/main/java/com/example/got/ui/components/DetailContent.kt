package com.example.got.ui.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.twotone.Favorite
import androidx.compose.material.icons.twotone.FavoriteBorder
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.got.R
import com.example.got.model.Character
import com.example.got.ui.theme.GOTTheme

@Composable
fun DetailContent(
    character: Character,
    isFavorite: Boolean,
    addToFavorite: (Character) -> Unit,
    deleteFromFavorite: (Character) -> Unit,
    modifier: Modifier = Modifier,
    onBackClick: () -> Unit,
) {
    Column(
        modifier = modifier
            .verticalScroll(rememberScrollState())
            .padding(horizontal = 16.dp)
            .fillMaxSize()
    ) {
        Icon(
            imageVector = Icons.Default.ArrowBack,
            contentDescription = stringResource(R.string.navigation_back),
            modifier = Modifier
                .padding(vertical = 16.dp)
                .clickable {onBackClick() }
        )
        Row {
            Box(modifier = Modifier.weight(1f)){
                Image(
                    painter = painterResource(id = character.photoId),
                    contentScale = ContentScale.FillBounds,
                    contentDescription = character.name,
                    modifier = Modifier.size(300.dp)
                )
                if(isFavorite){
                    IconButton(
                        onClick = { deleteFromFavorite(character) },
                        modifier = Modifier.align(Alignment.TopEnd)
                    ) {
                        Icon(
                            imageVector = Icons.Default.Favorite,
                            tint = Color.White,
                            contentDescription = "Favorite Button",
                            modifier = Modifier.fillMaxSize()
                        )
                    }
                }else{
                    IconButton(
                        onClick = { addToFavorite(character) },
                        modifier = Modifier.align(Alignment.TopEnd)
                    ) {
                        Icon(
                            imageVector = Icons.Default.FavoriteBorder,
                            tint = Color.White,
                            contentDescription = "Favorite Button",
                            modifier = Modifier.fillMaxSize()
                        )
                    }
                }
            }
            Spacer(modifier = Modifier.width(16.dp))
            Column {
                Text(text = stringResource(id = R.string.name, character.name))
                Spacer(modifier = Modifier.padding(5.dp))
                Text(text = stringResource(id = R.string.alias, character.alias))
                Spacer(modifier = Modifier.padding(5.dp))
                Text(text = stringResource(id = R.string.cast, character.cast))
                Spacer(modifier = Modifier.padding(5.dp))
                Text(text = stringResource(id = R.string.gender, character.gender))
                Spacer(modifier = Modifier.padding(5.dp))
                Text(text = stringResource(id = R.string.house, character.house))
            }
        }
        Spacer(modifier = Modifier.padding(5.dp))
        Text(text = character.detail, textAlign = TextAlign.Justify)
    }
}

@Preview(showBackground = true, device = Devices.PIXEL_4)
@Composable
fun DetailContentPrev() {
    GOTTheme {
        DetailContent(
            Character(1, "Eddard Stark", "Lord of Winterfell", "Sean Bean", "Male", "Stark", R.drawable.jon,"Lord Eddard Stark, also known as Ned Stark, was the head of House Stark, the Lord of Winterfell and Warden of the North, and later Hand of the King to King Robert I Baratheon. He was the older brother of Benjen, Lyanna and the younger brother of Brandon Stark. He is the father of Robb, Sansa, Arya, Bran, and Rickon by his wife, Catelyn Tully, and uncle of Jon Snow, who he raised as his bastard son. He was a dedicated husband and father, a loyal friend, and an honorable lord."),
            addToFavorite = {},
            isFavorite = true,
            deleteFromFavorite = {},
            onBackClick = {}
        )
    }
}
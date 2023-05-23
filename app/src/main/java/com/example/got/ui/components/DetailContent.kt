package com.example.got.ui.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
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
) {
    Column(
        modifier = modifier
            .verticalScroll(rememberScrollState())
            .padding(16.dp)
    ) {
        Row {
            Image(
                painter = painterResource(id = character.photoId),
                contentDescription = character.name,
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .weight(1f)
                    .size(200.dp)
            )
            Spacer(modifier = Modifier.width(16.dp))
            Column {
                Text(text = "Name ${character.name}")
                Text(text = "Alias ${character.alias}")
                Text(text = "Cast ${character.cast}")
                Text(text = "Gender ${character.gender}")
                Text(text = "House ${character.house}")
            }
        }
        Text(text = character.detail)
        if(isFavorite){
            IconButton(onClick = { deleteFromFavorite(character) }) {
                Icon(Icons.Default.Favorite, "Delete from favorite")
            }
        }else{
            IconButton(onClick = { addToFavorite(character) }) {
                Icon(Icons.Default.FavoriteBorder, "Add to favorite")
            }
        }
    }
}

@Preview(showBackground = true, device = Devices.PIXEL_4)
@Composable
fun DetailContentPrev() {
    GOTTheme {
        DetailContent(
            Character(1, "Eddard Stark", "Lord of Winterfell", "Sean Bean", "Male", "Stark", R.drawable.ned,"Lord Eddard Stark, also known as Ned Stark, was the head of House Stark, the Lord of Winterfell and Warden of the North, and later Hand of the King to King Robert I Baratheon. He was the older brother of Benjen, Lyanna and the younger brother of Brandon Stark. He is the father of Robb, Sansa, Arya, Bran, and Rickon by his wife, Catelyn Tully, and uncle of Jon Snow, who he raised as his bastard son. He was a dedicated husband and father, a loyal friend, and an honorable lord."),
            addToFavorite = {},
            isFavorite = true,
            deleteFromFavorite = {},

        )
    }
}
package com.example.got.ui.screen.detail

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.got.di.Injection
import com.example.got.ui.ViewModelFactory
import com.example.got.ui.common.UiState
import com.example.got.ui.components.DetailContent

@Composable
fun DetailScreen(
    id: Long,
    detailViewModel: DetailViewModel = viewModel(factory = ViewModelFactory(Injection.provideRepository(LocalContext.current))),
    navigateBack: () -> Unit,
) {
    detailViewModel.characterDetail.collectAsState(initial = UiState.Loading).value.let { uiState ->
        when(uiState){
            is UiState.Loading -> {
                detailViewModel.getCharacterById(id)
            }
            is UiState.Success -> {
                DetailContent(
                    character = uiState.data,
                    isFavorite = detailViewModel._isFavorite,
                    addToFavorite = { character ->  detailViewModel.addFavouriteUser(character) },
                    deleteFromFavorite = {character ->  detailViewModel.deleteFavouriteUser(character.id)}
                )
            }
            is UiState.Error -> {}
        }
    }
}
package com.example.got.ui.screen.favorite

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.got.di.Injection
import com.example.got.ui.ViewModelFactory
import com.example.got.ui.common.UiState
import com.example.got.ui.components.FavoriteContent

@Composable
fun FavoriteScreen(
    modifier: Modifier = Modifier,
    favoriteViewModel: FavoriteViewModel = viewModel(factory = ViewModelFactory(Injection.provideRepository(LocalContext.current))),
    navigateToDetail: (Long) -> Unit,
    navigateBack: () -> Unit
) {
    favoriteViewModel.favoriteCharacters.collectAsState(initial = UiState.Loading).value.let { uiState ->
        when(uiState){
            is UiState.Loading -> {
                favoriteViewModel.getFavouriteUser()
            }
            is UiState.Success -> {
                FavoriteContent(
                    modifier = modifier,
                    favoriteCharacters = uiState.data,
                    navigateToDetail = navigateToDetail,
                    onBackClick = navigateBack
                )
            }
            is UiState.Error -> {}
        }
    }

}
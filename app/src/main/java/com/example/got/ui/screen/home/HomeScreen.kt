package com.example.got.ui.screen.home

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.got.di.Injection
import com.example.got.ui.ViewModelFactory
import com.example.got.ui.common.UiState
import com.example.got.ui.components.HomeContent

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    homeViewModel: HomeViewModel = viewModel(factory = ViewModelFactory(Injection.provideRepository(LocalContext.current))),
    navigateToAbout: () -> Unit,
    navigateToDetail: (Long) -> Unit,
    navigateToFavorite: () -> Unit,
){
    val groupedCharacters by homeViewModel.groupedCharacters.collectAsState()
    val query by homeViewModel.query
    HomeContent(
        groupedCharacters = groupedCharacters,
        query = query,
        onQueryChange = homeViewModel::search,
        navigateToAbout = navigateToAbout,
        navigateToDetail = navigateToDetail,
        navigateToFavorite = navigateToFavorite,
        modifier = modifier
    )
}
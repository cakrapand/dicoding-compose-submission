package com.example.got.ui.screen.favorite

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.got.data.Repository
import com.example.got.model.Character
import com.example.got.ui.common.UiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class FavoriteViewModel(private val repository: Repository) : ViewModel() {

    private val _favoriteCharacters: MutableStateFlow<UiState<List<Character>>> = MutableStateFlow(UiState.Loading)
    val favoriteCharacters: StateFlow<UiState<List<Character>>>
        get() = _favoriteCharacters

    fun getFavouriteUser(){
        viewModelScope.launch{
            _favoriteCharacters.value = UiState.Loading
            repository.getFavouriteChar().collect{_favoriteCharacters.value = UiState.Success(it)}
        }
    }
}
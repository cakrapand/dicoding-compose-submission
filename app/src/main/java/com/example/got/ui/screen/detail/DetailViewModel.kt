package com.example.got.ui.screen.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.got.data.Repository
import com.example.got.model.Character
import com.example.got.ui.common.UiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class DetailViewModel(private val repository: Repository) : ViewModel() {

    private val _characterDetail: MutableStateFlow<UiState<Character>> = MutableStateFlow(UiState.Loading)
    val characterDetail: StateFlow<UiState<Character>>
        get() = _characterDetail

//    private val _isFavorite = MutableLiveData<Boolean>()
//    val isFavorite: LiveData<Boolean>
//        get() = _isFavorite

    var _isFavorite = false


    fun getCharacterById(id: Long){
        viewModelScope.launch {
            repository.getFavoriteCharById(id).collect{
                _characterDetail.value = UiState.Loading
                _isFavorite = it != null
                _characterDetail.value = UiState.Success(repository.getCharacterById(id))
            }
        }
    }

    fun addFavouriteUser(character: Character){
        viewModelScope.launch {
            repository.addFavouriteChar(character)
        }
    }

    fun deleteFavouriteUser(id: Long){
        viewModelScope.launch {
            repository.deleteFavouriteChar(id)
        }
    }
}
package com.example.got.ui.screen.home

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.got.data.Repository
import com.example.got.model.Character
import com.example.got.ui.common.UiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class HomeViewModel(private val repository: Repository) : ViewModel() {

    private val _groupedCharacters: MutableStateFlow<UiState<Map<String, List<Character>>>> = MutableStateFlow(UiState.Loading)
    val groupedCharacters: StateFlow<UiState<Map<String, List<Character>>>>
    get() = _groupedCharacters

    private val _query = mutableStateOf("")
    val query: State<String> get() = _query


    fun getAllCharacters(){
        _groupedCharacters.value = UiState.Loading
        _groupedCharacters.value = UiState.Success(repository.getAllCharacters().sortedBy { it.name }.groupBy { it.house })
    }

    fun search(newQuery: String) {
        _query.value = newQuery
        _groupedCharacters.value =  UiState.Success(repository.searchCharacters(newQuery).sortedBy { it.name }.groupBy { it.house })
    }
}


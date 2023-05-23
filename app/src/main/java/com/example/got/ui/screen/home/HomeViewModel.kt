package com.example.got.ui.screen.home

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.got.data.Repository
import com.example.got.model.Character
import com.example.got.ui.common.UiState
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class HomeViewModel(private val repository: Repository) : ViewModel() {


    private val _groupedCharacters = MutableStateFlow(
        repository.getAllCharacters().sortedBy { it.name }.groupBy { it.house }
    )
    val groupedCharacters: StateFlow<Map<String, List<Character>>> get() = _groupedCharacters

    private val _query = mutableStateOf("")
    val query: State<String> get() = _query

    fun search(newQuery: String) {
        _query.value = newQuery
        _groupedCharacters.value = repository.searchCharacters(newQuery).sortedBy { it.name }.groupBy { it.house }
    }
}


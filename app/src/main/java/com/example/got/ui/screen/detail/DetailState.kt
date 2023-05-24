package com.example.got.ui.screen.detail

import com.example.got.model.Character

data class DetailState(
    val character: Character,
    val isFavorite: Boolean
)
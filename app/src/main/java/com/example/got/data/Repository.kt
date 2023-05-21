package com.example.got.data

import com.example.got.model.Character
import com.example.got.model.FakeDataSource

class Repository {

    fun getCharacters(): List<Character> {
        return FakeDataSource.dummyCharacters
    }

    fun searchHeroes(query: String): List<Character>{
        return FakeDataSource.dummyCharacters.filter {
            it.name.contains(query, ignoreCase = true)
        }
    }
}
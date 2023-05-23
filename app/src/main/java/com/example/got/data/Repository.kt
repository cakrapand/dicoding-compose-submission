package com.example.got.data

import android.util.Log
import androidx.lifecycle.LiveData
import com.example.got.data.local.room.FavoriteDao
import com.example.got.model.Character
import com.example.got.model.FakeDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emitAll
import kotlinx.coroutines.flow.flow
import org.w3c.dom.Entity

class Repository private constructor(private val favoriteDao: FavoriteDao){

    fun getAllCharacters(): List<Character> {
        return FakeDataSource.dummyCharacters
    }

    fun getCharacterById(id: Long): Character {
        return FakeDataSource.dummyCharacters.first {
            it.id == id
        }
    }

    fun searchCharacters(query: String): List<Character>{
        return FakeDataSource.dummyCharacters.filter {
            it.name.contains(query, ignoreCase = true)
        }
    }

    fun getFavouriteChar(): Flow<List<Character>> {
        return favoriteDao.getAllFavoriteChar()
    }

    suspend fun addFavouriteChar(character: Character): Long{
        return favoriteDao.addFavouriteChar(character)
    }

    suspend fun deleteFavouriteChar(id: Long): Int{
        return favoriteDao.deleteFavouriteChar(id)
    }

    fun getFavoriteCharById(id: Long): Flow<Character> = favoriteDao.getFavoriteCharById(id)

    companion object {
        @Volatile
        private var instance: Repository? = null
        fun getInstance(
            favoriteDao: FavoriteDao,
        ): Repository =
            instance ?: synchronized(this) {
                instance ?: Repository(favoriteDao)
            }.also { instance = it }
    }
}
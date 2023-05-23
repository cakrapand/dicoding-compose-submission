package com.example.got.data.local.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.got.model.Character
import kotlinx.coroutines.flow.Flow

@Dao
interface FavoriteDao {

    @Query("SELECT * FROM FavoriteChar")
    fun getAllFavoriteChar(): Flow<List<Character>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addFavouriteChar(char: Character): Long

    @Query("DELETE FROM FavoriteChar WHERE id = :id")
    suspend fun deleteFavouriteChar(id: Long): Int

    @Query("SELECT * FROM FavoriteChar WHERE id = :id")
    fun getFavoriteCharById(id: Long): Flow<Character>

}
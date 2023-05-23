package com.example.got.di

import android.content.Context
import com.example.got.data.Repository
import com.example.got.data.local.room.FavoriteDatabase

object Injection {
    fun provideRepository(context: Context): Repository {
        val database = FavoriteDatabase.getInstance(context)
        val dao = database.favoriteDao()
        return Repository.getInstance(dao)
    }
}
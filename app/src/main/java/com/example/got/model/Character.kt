package com.example.got.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "FavoriteChar")
data class Character (

    @field:ColumnInfo(name = "Id")
    @field:PrimaryKey
    val id: Long,

    @field:ColumnInfo(name = "Name")
    val name: String,

    @field:ColumnInfo(name = "Alias")
    val alias: String,

    @field:ColumnInfo(name = "Cast")
    val cast: String,

    @field:ColumnInfo(name = "Gender")
    val gender: String,

    @field:ColumnInfo(name = "House")
    val house: String,

    @field:ColumnInfo(name = "PhotoId")
    val photoId: Int,

    @field:ColumnInfo(name = "Detail")
    val detail: String,
)
package com.example.evaluacinintermedia.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull

@Entity(tableName = "item_table")
data class ItemEntity(
    @PrimaryKey(autoGenerate = true)
    @NotNull
    val id: Int=0,
    val nombre: String,
    val precio: Int,
    val ctd: Int,
    val total:Int
)

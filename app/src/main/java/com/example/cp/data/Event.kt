package com.example.cp.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Event_table")
data class Event(
    @PrimaryKey(autoGenerate = true)
    val id:Int,
    val title:String,
    val text:String?,
    val date: Long
)

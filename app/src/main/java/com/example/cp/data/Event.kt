package com.example.cp.data

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "Event_table")
data class Event(
    @PrimaryKey(autoGenerate = true)
    val id:Int,
    val title:String,
    val text:String?,
    val date: Long
):Parcelable

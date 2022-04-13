package com.example.cp.data

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.cp.time
import java.text.SimpleDateFormat
import java.time.LocalDateTime
import java.util.*


@Dao
abstract interface EventDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addEvent(event: Event)
    @Delete
    suspend fun deleteEvent(event: Event)
    @Query("select * from Event_table Order by date desc")
     fun getAll():LiveData<List<Event>>
    val b : String?
        get() = time().CDate()

    @Query("select * from Event_table where date=:a ")
    fun getToday(a: String? =b):LiveData<List<Event>>



}
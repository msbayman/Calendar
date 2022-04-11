package com.example.cp.data

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.cp.data.Event

@Dao
abstract interface EventDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addEvent(event: Event)
    @Delete
    suspend fun deleteEvent(event: Event)
    @Query("select * from Event_table Order by id desc")
     fun getAll():LiveData<List<Event>>
}
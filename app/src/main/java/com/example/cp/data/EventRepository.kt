package com.example.cp.data

import androidx.lifecycle.LiveData



class EventRepository (private val eventDao: EventDao){
    val getAll:LiveData<List<Event>> = eventDao.getAll()
    val getToday:LiveData<List<Event>> = eventDao.getAll()

    suspend fun addEvent(event: Event){
        eventDao.addEvent(event)
    }
    suspend fun deleteEvent(event: Event){
        eventDao.deleteEvent(event)
    }

}
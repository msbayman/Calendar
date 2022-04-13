package com.example.cp.data

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import androidx.room.Entity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class EventViewModel(application: Application):AndroidViewModel(application) {

    val getAll:LiveData<List<Event>>
    val getToday:LiveData<List<Event>>
    private val repository:EventRepository

    init {
        val eventDao=EventDataBase.getDataBase(application).eventDao()
        repository=EventRepository(eventDao)
        getAll=repository.getAll
        getToday=repository.getToday
    }
    fun addEvent (event: Event){
        viewModelScope.launch(Dispatchers.IO) {
            repository.addEvent(event)
        }
    }
    fun deleteEvent (event: Event){
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteEvent(event)
        }
    }


}
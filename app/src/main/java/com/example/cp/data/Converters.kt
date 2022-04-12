package com.example.cp.data

import androidx.room.TypeConverter
import java.lang.Double.valueOf
import java.lang.String.valueOf
import java.math.RoundingMode.valueOf
import java.time.Instant
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.ZoneId
import java.time.ZoneId.systemDefault

import java.sql.Date

import java.time.ZoneId.systemDefault
import java.util.*

class Converters {
    @TypeConverter
    fun fromTimestamp(value: Long?): Date? {
        return value?.let { Date(it) }
    }

    @TypeConverter
    fun dateToTimestamp(date: Date?): Long? {
        return date?.time?.toLong()
    }






}
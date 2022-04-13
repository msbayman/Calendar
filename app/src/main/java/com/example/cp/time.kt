package com.example.cp

import kotlinx.android.synthetic.main.allevents.view.*
import java.text.SimpleDateFormat
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.*
import kotlin.time.ExperimentalTime
import kotlin.time.milliseconds

class time {


    @OptIn(ExperimentalTime::class)
    fun CDate(): String {
        val current = LocalDateTime.now()

        val formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy")
        val formatted = current.format(formatter)
        val e = SimpleDateFormat("dd-MM-yyyy").parse(formatted)
        val r=e.time.milliseconds.toLongMilliseconds()




return r.toString()



    }






}
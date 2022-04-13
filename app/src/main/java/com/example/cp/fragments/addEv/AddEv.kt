package com.example.cp.fragments.addEv


import android.app.DatePickerDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.example.cp.R
import com.example.cp.data.Event
import com.example.cp.data.EventViewModel
import com.example.cp.time
import kotlinx.android.synthetic.main.fragment_add_ev.*
import kotlinx.android.synthetic.main.fragment_add_ev.view.*
import java.io.IOError
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.*
import kotlin.time.ExperimentalTime
import kotlin.time.milliseconds


class AddEv : Fragment() {

    private lateinit var mEventViewModel: EventViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_add_ev, container, false)

        mEventViewModel = ViewModelProvider(this)[EventViewModel::class.java]






         //choose date
        val myCalendar = Calendar.getInstance()
        val datePicker = DatePickerDialog.OnDateSetListener { view, year, month, dayOfMonth ->
            myCalendar.set(Calendar.YEAR, year)
            myCalendar.set(Calendar.MONTH, month)
            myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth)
            updateLable(myCalendar)
        }

        view.btnTime.setOnClickListener {
            DatePickerDialog(
                requireContext(),
                datePicker,
                myCalendar.get(Calendar.YEAR),
                myCalendar.get(Calendar.MONTH),
                myCalendar.get(Calendar.DAY_OF_MONTH)
            ).show()
        }



        view.back.setOnClickListener{
            view.findNavController().navigate(R.id.action_addEv_to_home2)
        }

        view.save.setOnClickListener{






            IsertToDataBase()




//            txtDate.text=null
//            txtText.text=null
//            descreption.text=null




//            view.findNavController().navigate(R.id.action_addEv_to_home2)
        }


























        return view
    }

    @OptIn(ExperimentalTime::class)
    private fun IsertToDataBase() {
        val date =txtDate.text.toString()
        //changedate to mili in insert
//        val date =txtDate.text.toString()
//        val k=date.toLong()
//        val r=k.milliseconds.toString().toLong()
//        val r=converttime(date).toString().toLong()
//        val e = SimpleDateFormat("dd-MM-yyyy").parse(date)
//        val r=e.time.milliseconds.toLongMilliseconds()





        val title=txtText.text.toString()
        val text=descreption.text.toString()

        if (inputCheck2(title,date)){

            Toast.makeText(requireContext(), "empty", Toast.LENGTH_SHORT).show()


        }
        else{
            //changedate to mili in insert
            val date =txtDate.text.toString()
//        val k=date.toLong()
//        val r=k.milliseconds.toString().toLong()
//        val r=converttime(date).toString().toLong()
            val e = SimpleDateFormat("dd-MM-yyyy").parse(date)
            val r=e.time.milliseconds.toLongMilliseconds()





           val event= Event(0,title,text,r)
            mEventViewModel.addEvent(event)



            Toast.makeText(requireContext(), "Added", Toast.LENGTH_SHORT).show()
            view?.findNavController()?.navigate(R.id.action_addEv_to_home2)


        }
    }
    private fun inputCheck2 (title: String, date:String):Boolean{
        return title.isEmpty()|| (return date==null)

    }

    //choose date
    private fun updateLable(myCalendar: Calendar) {
        val myformat = "dd-MM-yyyy"
        val sdf = SimpleDateFormat(myformat, Locale.ENGLISH)
        view?.txtDate?.text = sdf.format(myCalendar.time)
//        view?.txtDate?.text = myCalendar.timeInMillis.toString()


    }

     private  fun converttime (s:String): LocalDate? {
            // Format y-M-d or yyyy-MM-d
            val string = s
            val date = LocalDate.parse(string, DateTimeFormatter.BASIC_ISO_DATE)

            return (date)
        }







}

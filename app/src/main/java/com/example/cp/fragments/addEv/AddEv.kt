package com.example.cp.fragments.addEv


import android.app.DatePickerDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.findNavController
import com.example.cp.R
import com.example.cp.data.Event
import com.example.cp.data.EventViewModel
import kotlinx.android.synthetic.main.fragment_add_ev.*
import kotlinx.android.synthetic.main.fragment_add_ev.view.*
import java.text.SimpleDateFormat
import java.util.*


class AddEv : Fragment() {

    private lateinit var mEventViewModel: EventViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_add_ev, container, false)








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

    private fun IsertToDataBase() {
        val date :Long=txtDate.text.toString().toBigDecimal().longValueExact()
        val title=txtText.text.toString()
        val text=descreption.text.toString()

        if (inputCheck2(title,date)){
            Toast.makeText(requireContext(), "empty", Toast.LENGTH_SHORT).show()

        }
        else{
           val event= Event(0,title,text,date)
            mEventViewModel.addEvent(event)
            Toast.makeText(requireContext(), "Added", Toast.LENGTH_SHORT).show()

        }
    }
    private fun inputCheck2 (title: String, date:Long):Boolean{
        return title.isEmpty()|| (return date==null)

    }

    //choose date
    private fun updateLable(myCalendar: Calendar) {
        val myformat = "dd-MM-yyyy"
        val sdf = SimpleDateFormat(myformat, Locale.ENGLISH)
        view?.txtDate?.text = sdf.format(myCalendar.time)
    }



}

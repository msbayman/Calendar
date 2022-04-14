package com.example.cp.fragments.Update

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.cp.R
import com.example.cp.data.Event
import com.example.cp.data.EventViewModel
import kotlinx.android.synthetic.main.fragment_add_ev.view.*
import kotlinx.android.synthetic.main.fragment_uppdate_ev.view.*
import kotlinx.android.synthetic.main.todayevent.view.*
import java.text.SimpleDateFormat


class UppDateEv : Fragment() {
    private  val args by navArgs<UppDateEvArgs>()
    private lateinit var mEventViewModel: EventViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view= inflater.inflate(R.layout.fragment_uppdate_ev, container, false)
        mEventViewModel = ViewModelProvider(this)[EventViewModel::class.java]




       val x= args.currentevent.date.toString()

        val simpleDateFormat = SimpleDateFormat("dd-MM-yyyy")
        val dateString = simpleDateFormat.format(x.toLong())
        view.txtDateUp.text = String.format(dateString)







       view.descreptionUP.setText(args.currentevent.text.toString())
        view.txtTextUP.setText(args.currentevent.title.toString())






        view.backUP.setOnClickListener {

            view?.findNavController()?.navigate(R.id.action_uppDateEv_to_home2)
        }


        view.saveUp.setOnClickListener {
            update()
        }
        return view
    }


    fun update(){
        val event= Event(args.currentevent.id,view?.txtTextUP?.text.toString(),view?.descreptionUP?.text.toString(),args.currentevent.date.toLong())
        mEventViewModel.addEvent(event)



        Toast.makeText(requireContext(), "Added", Toast.LENGTH_SHORT).show()
        view?.findNavController()?.navigate(R.id.action_uppDateEv_to_home2)
    }


}

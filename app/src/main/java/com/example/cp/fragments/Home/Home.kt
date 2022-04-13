package com.example.cp.fragments.Home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListAdapter
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cp.R
import com.example.cp.data.Event
import com.example.cp.data.EventViewModel
import kotlinx.android.synthetic.main.fragment_add_ev.view.*
import kotlinx.android.synthetic.main.fragment_home.view.*
import java.lang.reflect.Array.get
import java.lang.reflect.Array.set


class Home : Fragment() {

    private lateinit var mEventViewModel: EventViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_home, container, false)
        //RecycleVie
        val adapterAll=allAdapter()
        val recyclerViewAll=view.RCall
        recyclerViewAll.adapter=adapterAll
        recyclerViewAll.layoutManager=LinearLayoutManager(requireContext())

//        //evetviewmodel
//        mEventViewModel= ViewModelProvider(this)[EventViewModel::class.java]
//        mEventViewModel.getAll.observe(viewLifecycleOwner, Observer {event->
//           adapterAll.setData(event) })





        val adapterToday=todayAdapter()
        val recyclerViewToday=view.RCtoday
        recyclerViewToday.adapter=adapterToday
        recyclerViewToday.layoutManager=LinearLayoutManager(requireContext())


        //evetviewmodel
        mEventViewModel= ViewModelProvider(this)[EventViewModel::class.java]
        mEventViewModel.getAll.observe(viewLifecycleOwner, Observer {event->
            adapterAll.setData(event) })
        mEventViewModel.getToday.observe(viewLifecycleOwner, Observer {event->
            adapterToday.ssetData(event) })

        view.btnAdd.setOnClickListener {
            view.findNavController().navigate(R.id.action_home2_to_addEv)
        }




        return view
    }


}

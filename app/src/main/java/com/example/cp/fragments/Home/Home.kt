package com.example.cp.fragments.Home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.cp.R
import kotlinx.android.synthetic.main.fragment_add_ev.view.*
import kotlinx.android.synthetic.main.fragment_home.view.*


class Home : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_home, container, false)


        view.btnAdd.setOnClickListener {
            view.findNavController().navigate(R.id.action_home2_to_addEv)
        }




        return view
    }


}

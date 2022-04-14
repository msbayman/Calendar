package com.example.cp.fragments.Home

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.cp.R
import com.example.cp.data.Event
import com.example.cp.fragments.Update.UppDateEv
import com.example.cp.fragments.Update.UppDateEvDirections
import com.example.cp.fragments.addEv.AddEv

import kotlinx.android.synthetic.main.allevents.view.*

import kotlinx.android.synthetic.main.allevents2.view.txtDateall
import kotlinx.android.synthetic.main.allevents2.view.txtTitleall
import java.text.SimpleDateFormat

class allAdapter : RecyclerView.Adapter<allAdapter.MyViewHolder>() {


    private var evenrList = emptyList<Event>()

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.allevents, parent, false)
        )
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        val currentItem = evenrList[position]
        val simpleDateFormat = SimpleDateFormat("dd-MM-yyyy")
        val dateString = simpleDateFormat.format(currentItem.date.toString().toLong())
        holder.itemView.txtDateall.text = String.format(dateString)
        holder.itemView.txtTitleall.text = currentItem.title

        holder.itemView.alleventsLayout.setOnClickListener {

         val action=HomeDirections.actionHome2ToUppDateEv3(currentItem)
            holder.itemView.findNavController().navigate(action)
        }

    }

    override fun getItemCount(): Int {
        return evenrList.size

    }

    @SuppressLint("NotifyDataSetChanged")
    fun setData(event: List<Event>) {
        this.evenrList = event
        notifyDataSetChanged()

    }

}
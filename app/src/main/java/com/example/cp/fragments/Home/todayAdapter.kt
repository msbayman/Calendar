package com.example.cp.fragments.Home

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.cp.R
import com.example.cp.data.Event
import kotlinx.android.synthetic.main.allevents2.view.*
import kotlinx.android.synthetic.main.todayevent.view.*

class todayAdapter: RecyclerView.Adapter<todayAdapter.MyViewHolder>()  {

    private var eevenrList = emptyList<Event>()
    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.todayevent, parent, false))
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = eevenrList[position]

        holder.itemView.txtTitle.text=currentItem.title

    }

    override fun getItemCount(): Int {
        return eevenrList.size
    }
    @SuppressLint("NotifyDataSetChanged")
    fun ssetData(event: List<Event>) {
        this.eevenrList = event
        notifyDataSetChanged()

    }
}
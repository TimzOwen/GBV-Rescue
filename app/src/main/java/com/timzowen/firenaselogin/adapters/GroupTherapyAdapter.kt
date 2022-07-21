package com.timzowen.firenaselogin.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.timzowen.firenaselogin.R
import com.timzowen.firenaselogin.data.GroupMeeting
import com.timzowen.firenaselogin.databinding.GrouptherapyLayoutBinding
import org.w3c.dom.Text

class GroupTherapyAdapter(private val groupTherapyList: ArrayList<GroupMeeting>) : RecyclerView.Adapter<GroupTherapyAdapter.MyViewHolder> (){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        // Inflate the layout of
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.grouptherapy_layout,parent,false)

        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        return groupTherapyList.size
    }

    class MyViewHolder (itemView : View): RecyclerView.ViewHolder(itemView){
        val topic : TextView = itemView.findViewById(R.id.tv_topic)
        val leadDoctor : Text = itemView.findViewById(R.id.tv_lead_doctor)
        val zoomDate : TextView = itemView.findViewById(R.id.date_zoom_meeting)
    }

}
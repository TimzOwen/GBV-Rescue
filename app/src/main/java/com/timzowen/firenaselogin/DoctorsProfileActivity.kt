package com.timzowen.idoctor

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.timzowen.firenaselogin.R
import com.timzowen.idoctor.adapters.DoctorsProfileAdapter
import com.timzowen.idoctor.data.DataDoctorsProfile

class DoctorsProfileActivity : AppCompatActivity(), DoctorsProfileAdapter.onItemClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_doctos_profile)

        val recyclerView = findViewById<RecyclerView>(R.id.recycler_profile_doctors)

        val dataDoctors = DataDoctorsProfile().loadDoctorsProfile()

        recyclerView.adapter = DoctorsProfileAdapter(this,dataDoctors,this)
        recyclerView.hasFixedSize()

    }

    override fun onItemClick(position: Int) {
        when(position){
            0 -> {
                val doctorNameProfile = Intent(this,IDoctorActivity::class.java)
                doctorNameProfile.putExtra("name",position)
                doctorNameProfile.putExtra("Quote",position)
                startActivity(doctorNameProfile)
            }
            1 ->{
                val doctor3 = Intent(this,IDoctorActivity::class.java)
                doctor3.putExtra("name",position)
                doctor3.putExtra("quote",position)
                startActivity(doctor3)
            }
            2 -> {
                val doctor3 = Intent(this,IDoctorActivity::class.java)
                doctor3.putExtra("name",position)
                doctor3.putExtra("quote",position)
                startActivity(doctor3)
            }
            3->{
                val doctor3 = Intent(this,IDoctorActivity::class.java)
                doctor3.putExtra("name",position)
                doctor3.putExtra("quote",position)
                startActivity(doctor3)
            }
            4 ->{

            }
        }
    }
}
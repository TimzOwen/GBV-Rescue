package com.timzowen.idoctor

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.timzowen.firenaselogin.databinding.ActivityIdoctorBinding


class IDoctorActivity : AppCompatActivity() {

    private lateinit var binding: ActivityIdoctorBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityIdoctorBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val bundle : Bundle?= intent.extras
        val docName  = bundle!!.getString("Name")
        val docImage = bundle!!.getInt("profile")
        val docQuote = bundle!!.getString("quote")

        binding.nameProfile.text = docName
        binding.ivDocProfileChat.setImageResource(docImage)
        binding.countryProfile.text = docQuote


       binding.tbnBookTherapyDoctor.setOnClickListener {
           startActivity(Intent(this,BookAppointmentActivity::class.java))
       }
    }
}
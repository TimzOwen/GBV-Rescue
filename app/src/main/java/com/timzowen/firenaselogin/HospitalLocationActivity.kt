package com.timzowen.idoctor

import android.annotation.SuppressLint
import android.app.ProgressDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.webkit.WebView
import com.timzowen.firenaselogin.R

class HospitalLocationActivity : AppCompatActivity() {

    lateinit var progressDialog : ProgressDialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hospital_location)


        initView()

        Handler().postDelayed({
            progressDialog.dismiss()
        },6000)

    }

    //create a function to initialize the google maps API
    @SuppressLint("SetJavaScriptEnabled")
    private fun initView(){
        //find the ID to the map
        val mapview : WebView = findViewById<WebView>(R.id.wv_mapview)

        progressDialog = ProgressDialog(this)
        progressDialog.setMessage("Getting nearby hospitals.....")
        progressDialog.setCancelable(false)
        progressDialog.show()

        mapview.settings.javaScriptEnabled = true
        mapview.loadUrl("https://www.google.com/maps/d/u/0/viewer?hl=en_US&mid=1znF44mhGh4VX9zCVeGWvzAPZDDE&ll=-0.2683282548601752%2C36.08479030000002&z=13")
    }
}
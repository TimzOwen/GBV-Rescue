package com.timzowen.idoctor

import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import com.timzowen.firenaselogin.MainActivity
import com.timzowen.firenaselogin.R
import com.timzowen.firenaselogin.databinding.ActivityEmergencyBinding
import com.timzowen.idoctor.adapters.EmergencyAdapter
import com.timzowen.idoctor.data.DataEmergency

class EmergencyActivity : AppCompatActivity(),EmergencyAdapter.onItemClickListener {

    private lateinit var binding: ActivityEmergencyBinding

    private val requestPermissionLauncher =
        registerForActivityResult(
            ActivityResultContracts.RequestPermission()
        ) { isGranted: Boolean ->
            if (isGranted) {
                onClickRequestPermission(binding.recyclerEmergency)
            } else {
                Toast.makeText(this, "Permission not granted", Toast.LENGTH_SHORT).show()
            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEmergencyBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //get the recycler view
        val recyclerviewEmergency = findViewById<RecyclerView>(R.id.recycler_emergency)

        //get all the numbers in the emergency data package
        val dataNumbers = DataEmergency().loadCalls()

        // map all the data in the adapter
        recyclerviewEmergency.adapter = EmergencyAdapter(this,dataNumbers,this)
        recyclerviewEmergency.hasFixedSize()
    }

    override fun onItemClick(position: Int) {
        if (position == 0){
            callPhone()
            Toast.makeText(this, "clicked $position", Toast.LENGTH_SHORT).show()
        }
    }
    private fun callPhone() {
        val intent = Intent(Intent.ACTION_CALL, Uri.parse("tel:" + "1122334455"))
        startActivity(intent)

    }

    private fun onClickRequestPermission(view: View) {
        when {
            ContextCompat.checkSelfPermission(
                this,
                android.Manifest.permission.CALL_PHONE
            ) == PackageManager.PERMISSION_GRANTED -> {
                 binding.recyclerEmergency.showSnackbar(
                    view,
                    getString(R.string.permission_granted),
                    Snackbar.LENGTH_INDEFINITE,
                    null
                ) {}
            }

            ActivityCompat.shouldShowRequestPermissionRationale(
                this,
                android.Manifest.permission.CALL_PHONE
            ) -> {
                binding.recyclerEmergency.showSnackbar(
                    view,
                    getString(R.string.permission_required),
                    Snackbar.LENGTH_INDEFINITE,
                    getString(R.string.ok)
                ) {
                    requestPermissionLauncher.launch(
                        android.Manifest.permission.CALL_PHONE
                    )
                }
            }

            else -> {
                requestPermissionLauncher.launch(
                    android.Manifest.permission.CALL_PHONE
                )
            }
        }
    }

    private fun View.showSnackbar(
        view: View,
        msg: String,
        length: Int,
        actionMessage: CharSequence?,
        action: (View) -> Unit
    ) {
        val snackbar = Snackbar.make(view, msg, length)
        if (actionMessage != null) {
            snackbar.setAction(actionMessage) {
                action(this)
            }.show()
        } else {
            snackbar.show()
        }
    }
}
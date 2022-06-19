package com.timzowen.firenaselogin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.database.*
import com.timzowen.firenaselogin.databinding.ActivityGroupTherapyBinding
import com.timzowen.idoctor.adapters.GroupTherapyAdapter
import com.timzowen.idoctor.model.GroupTherapy
import java.text.FieldPosition

class GroupTherapyActivity : AppCompatActivity() {

    private lateinit var dbRef : DatabaseReference
    private lateinit var binding: ActivityGroupTherapyBinding
    private lateinit var userArrayList : ArrayList<GroupTherapy>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGroupTherapyBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recyclerGroupTherapy.layoutManager = LinearLayoutManager(this)

        userArrayList = arrayListOf<GroupTherapy>()
        binding.recyclerGroupTherapy.hasFixedSize()

        dbRef = FirebaseDatabase.getInstance().getReference("ZoomMeetings")
        dbRef.addValueEventListener(object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists()){
                    for (userSnapshot in snapshot.children){
                        val user = userSnapshot.getValue(GroupTherapy::class.java)
                        userArrayList.add(user!!)
                    }
                    //val adapter = GroupTherapyAdapter(this@GroupTherapyActivity,userArrayList,this@GroupTherapyActivity)
                    //binding.recyclerGroupTherapy.adapter = adapter
                }
            }

            override fun onCancelled(error: DatabaseError) {
                // Toast a network error
            }
        })
    }
}
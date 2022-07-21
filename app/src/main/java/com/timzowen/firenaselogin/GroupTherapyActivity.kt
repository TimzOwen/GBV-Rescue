package com.timzowen.firenaselogin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.*
import com.timzowen.firenaselogin.adapters.GroupTherapyAdapter
import com.timzowen.firenaselogin.data.GroupMeeting
import com.timzowen.firenaselogin.databinding.GrouptherapyLayoutBinding

class GroupTherapyActivity : AppCompatActivity() {

    private lateinit var dbRef : DatabaseReference
    private lateinit var groupRecyclerView : RecyclerView
    private lateinit var groupArrayList : ArrayList<GroupMeeting>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_group_therapy)

        groupRecyclerView = findViewById(R.id.groupTherapyRecycler_view)
        groupRecyclerView.layoutManager = LinearLayoutManager(this)
        groupRecyclerView.hasFixedSize()

        groupArrayList = arrayListOf<GroupMeeting>()

        getAllMeetings()

    }
    private fun getAllMeetings(){
        dbRef = FirebaseDatabase.getInstance().getReference("ZoomMeetings")

        dbRef.addValueEventListener(object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot){
                if (snapshot.exists()){
                    for(zoomSnapshot in snapshot.children){
                        val zoom = zoomSnapshot.getValue(GroupMeeting::class.java)
                        groupArrayList.add(zoom!!)
                    }
                    groupRecyclerView.adapter = GroupTherapyAdapter(groupArrayList)
                }
            }

            override fun onCancelled(error: DatabaseError) {
                //
            }
        })
    }
}
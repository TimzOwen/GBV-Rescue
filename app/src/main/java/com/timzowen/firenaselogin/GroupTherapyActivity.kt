package com.timzowen.firenaselogin

import android.app.ProgressDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
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
    private lateinit var progressDialog : ProgressDialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_group_therapy)

        groupRecyclerView = findViewById(R.id.groupTherapyRecycler_view)
        groupRecyclerView.layoutManager = LinearLayoutManager(this)
        groupRecyclerView.hasFixedSize()

        groupArrayList = arrayListOf<GroupMeeting>()

        getAllMeetings()

        Handler().postDelayed({
            progressDialog.dismiss()
        },4000)



    }
    private fun getAllMeetings(){
        dbRef = FirebaseDatabase.getInstance().getReference("ZoomMeetings")
        progressDialog = ProgressDialog(this)
        progressDialog.setMessage("Fetching data.....")
        progressDialog.setCancelable(false)
        progressDialog.show()

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
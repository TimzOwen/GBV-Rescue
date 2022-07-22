package com.timzowen.idoctor

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.timzowen.firenaselogin.MainActivity
import com.timzowen.firenaselogin.databinding.ActivityLoginBinding


class LoginActivity : AppCompatActivity() {

    private lateinit var binding : ActivityLoginBinding
    private lateinit var firebaseAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        firebaseAuth = FirebaseAuth.getInstance()

        // make a direct call to dial intents
        binding.btnCallEmergency.setOnClickListener {
            startActivity(Intent(this,EmergencyActivity::class.java))
        }
        //navigate back to sign up activity
        binding.btnSignUp.setOnClickListener {
            startActivity(Intent(this,SignUpActivity::class.java))
        }

        //Authenticate user login
        binding.btnLogin.setOnClickListener {

            val userEmail = binding.etSigninEmail.text.toString()
            val userPassword = binding.etPasswordLogin.text.toString()

            if (userEmail.isNotEmpty() && userPassword.isNotEmpty()){

                firebaseAuth.signInWithEmailAndPassword(userEmail,userPassword).addOnCompleteListener {
                    if (it.isSuccessful){
                        val intent = Intent(this,MainActivity::class.java)
                        startActivity(intent)
                    }else{
                        Toast.makeText(this, it.exception.toString(), Toast.LENGTH_SHORT).show()
                    }
                }
            }else{
                Toast.makeText(this, "Fields cannot be empty", Toast.LENGTH_SHORT).show()
            }

        }
    }
}
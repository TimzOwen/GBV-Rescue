package com.timzowen.idoctor

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.timzowen.firenaselogin.databinding.ActivitySignUpBinding

class SignUpActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySignUpBinding
    private lateinit var firebaseAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        firebaseAuth = FirebaseAuth.getInstance()

        binding.tvMemberLogin.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }

        binding.btnCreateUserAccountf.setOnClickListener {

            val userEmail = binding.etSignupUserEmail.text.toString()
            val password = binding.etUsersignupPassword.text.toString()
            val confirmPswd = binding.etSignupConfirmPswd.text.toString()

            //check if the fields are not empty
            if (userEmail.isNotEmpty() && password.isNotEmpty() && confirmPswd.isNotEmpty()) {
                if (password == confirmPswd) {
                    firebaseAuth.createUserWithEmailAndPassword(userEmail, password)
                        .addOnCompleteListener {
                            if (it.isSuccessful) {
                                // sign up user on success
                                val intent = Intent(this, LoginActivity::class.java)
                                startActivity(intent)
                            } else {
                                Toast.makeText(this, it.exception.toString(), Toast.LENGTH_SHORT)
                                    .show()
                            }
                        }
                } else {
                    Toast.makeText(this, "field cannot be empty", Toast.LENGTH_SHORT).show()
                }
            }

        }

    }
}
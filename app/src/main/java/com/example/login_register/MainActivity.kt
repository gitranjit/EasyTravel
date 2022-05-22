package com.example.login_register

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class MainActivity : AppCompatActivity() {




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



    val signinbtn=findViewById<Button>(R.id.btnSignIn)
        signinbtn.setOnClickListener {

            val intent=Intent(this,Cities::class.java)
                startActivity(intent)

        }

        val createAcc=findViewById<TextView>(R.id.tvRegister)
        createAcc.setOnClickListener {
            val intent=Intent(this,Register::class.java)
            startActivity(intent)
        }

        val forgotPass=findViewById<TextView>(R.id.tvForgotPass)
        forgotPass.setOnClickListener {
            startActivity(Intent(this,ForgotPassword::class.java))
        }
    }




}
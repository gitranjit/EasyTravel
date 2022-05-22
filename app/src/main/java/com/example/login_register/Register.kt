package com.example.login_register

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Toast
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class Register : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)


        val btnBack=findViewById<ImageButton>(R.id.btnBack)
        btnBack.setOnClickListener{

            val intent= Intent(this,MainActivity::class.java)
                    startActivity(intent)

        }
        val btnregister=findViewById<Button>(R.id.btnRegister)
        btnregister.setOnClickListener {
            Toast.makeText(this,"Account Created",Toast.LENGTH_SHORT).show()
            startActivity(Intent(this,Cities::class.java))
        }
    }
}
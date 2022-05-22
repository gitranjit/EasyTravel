package com.example.login_register

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView

class BookHotel : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_book_hotel)

        val bookroom=findViewById<Button>(R.id.btnBookNow)
        bookroom.setOnClickListener {
            startActivity(Intent(this,BookRoom::class.java))
        }



    }
}
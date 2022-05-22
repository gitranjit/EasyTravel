package com.example.login_register

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView

class Facilities : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_facilities)

        val bookbus=findViewById<Button>(R.id.btnbookBus)
        bookbus.setOnClickListener {
            startActivity(Intent(this,Travels::class.java))
        }

        val bookhotel=findViewById<Button>(R.id.btnHotel)

        bookhotel.setOnClickListener {
            val intent=Intent(this,BookHotel::class.java)
            startActivity(intent)
        }

        val cityImage=findViewById<ImageView>(R.id.ivCityImage)
        val city=findViewById<TextView>(R.id.etcityName)
        val cityName=intent.getStringExtra("City Name")
        city.setText(cityName)
        when(cityName){
            "Mumbai"->cityImage.setImageResource(R.drawable.mumbai_)
            "Delhi"->cityImage.setImageResource(R.drawable.delhi)
            "Chennai"->cityImage.setImageResource(R.drawable.chennai)
            "Kolkata"->cityImage.setImageResource(R.drawable.kolkata)
            "Bangalore"->cityImage.setImageResource(R.drawable.begalore)
            "Hydrabad"->cityImage.setImageResource(R.drawable.hydrabaad)
        }

        val historybtn=findViewById<Button>(R.id.btnHistory)
        historybtn.setOnClickListener {

            val inten=Intent(this,History::class.java)
            inten.putExtra("City Name",cityName)
            startActivity(inten)
        }
    }
}
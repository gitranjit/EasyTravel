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
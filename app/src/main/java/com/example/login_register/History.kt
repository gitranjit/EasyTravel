package com.example.login_register

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class History : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_history)

        val cityName=intent.getStringExtra("City Name")
        val cityImage=findViewById<ImageView>(R.id.ivCityImage)
        val city=findViewById<TextView>(R.id.tvCityName)
        val history=findViewById<TextView>(R.id.tvHistory)
        city.text=cityName
//        when(cityName){
//            "Mumbai"->history.setText(R.string.mumbai_history)
//            "Delhi"->history.setText(R.string.delhi_history)
//            "Hydrabad"->history.setText(R.string.hydrabad_history)
//            "Kolkata"->history.setText(R.string.kolkata_history)
//            "Chennai"->history.setText(R.string.chennai_history)
//            "Bangalore"->history.setText(R.string.bangalore_history)
//        }
    }
}
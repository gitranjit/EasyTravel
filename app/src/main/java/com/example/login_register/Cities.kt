package com.example.login_register

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.TextView

class Cities : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cities)

//        val intent = Intent(this,Facilities::class.java)
//        val mumbaibtn=findViewById<ImageButton>(R.id.ibMumbai)
//        mumbaibtn.setOnClickListener{
//            val mumbai=findViewById<TextView>(R.id.tvMumbai)
//            val cityName="Mumbai"
//            val intent = Intent(this,Facilities::class.java)
//            intent.putExtra("City Name",cityName)
//            startActivity(intent)
//        }


    }

    fun openFascilities(view: android.view.View) {
        var cityName=""
        when(view?.id)
        {
            R.id.ibMumbai-> cityName="Mumbai"
            R.id.ibDelhi->cityName="Delhi"
            R.id.ibBangalore-> cityName="Bangalore"
            R.id.ibChennai->cityName="Chennai"
            R.id.ibKolkata-> cityName="Kolkata"
            R.id.ibHydrabad->cityName="Hydrabad"
        }
        val intent = Intent(this,Facilities::class.java)
        intent.putExtra("City Name",cityName)
        startActivity(intent)
    }

//    public fun onClick (v: View ?) {
//        var cityName=""
//        when(v?.id)
//        {
//            R.id.ibMumbai-> cityName="Mumbai"
//            R.id.ibDelhi->cityName="Delhi"
//            R.id.ibBangalore-> cityName="Bangalore"
//            R.id.ibChennai->cityName="Chennai"
//            R.id.ibKolkata-> cityName="Kolkata"
//            R.id.ibHydrabad->cityName="Hydrabad"
//        }
//        val intent = Intent(this,Facilities::class.java)
//        intent.putExtra("City Name",cityName)
//        startActivity(intent)
//    }
}



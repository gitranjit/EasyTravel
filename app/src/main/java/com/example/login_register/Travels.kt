package com.example.login_register

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*

class Travels : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_travels)

        val radiogrpac=findViewById<RadioGroup>(R.id.rgTravels)
        val acbtn=radiogrpac.checkedRadioButtonId
        val ac=findViewById<RadioButton>(acbtn)

        val radiogrpseating=findViewById<RadioGroup>(R.id.rgTravels)
        val seatbtn=radiogrpseating.checkedRadioButtonId
        val seating=findViewById<RadioButton>(acbtn)


        val next=findViewById<Button>(R.id.btnNext)

        next.setOnClickListener {
//            if(ac==null){
//                Toast.makeText(this,"Select requirements",Toast.LENGTH_SHORT).show()
//                startActivity(Intent(this,Travels::class.java))
//            }
//            else{
//                bookNext()
//            }
            bookNext()
        }
        val book=findViewById<Button>(R.id.btnbookTravels)
        book.setOnClickListener {
            if(seating==null){
                Toast.makeText(this,"Select requirements",Toast.LENGTH_SHORT).show()
                startActivity(Intent(this,Travels::class.java))
            }
            else{
                finalBook()
            }

        }

    }

    fun bookNext(){
        val radiogrp=findViewById<RadioGroup>(R.id.rgTravels)
        radiogrp.visibility=View.GONE
        val acdisc=findViewById<TextView>(R.id.tvacdisc)
        acdisc.visibility=View.GONE
        val next=findViewById<Button>(R.id.btnNext)
        next.visibility=View.GONE
        val seatRadiogrp=findViewById<RadioGroup>(R.id.rgTravelsSeat)
        seatRadiogrp.visibility=View.VISIBLE
        val book=findViewById<Button>(R.id.btnbookTravels)
        book.visibility=View.VISIBLE
    }

    fun finalBook(){
        val billamt=findViewById<TextView>(R.id.tvTravelsBill)

        billamt.visibility=View.VISIBLE
    }
}
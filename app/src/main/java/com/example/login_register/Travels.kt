package com.example.login_register

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*

class Travels : AppCompatActivity() {
    var total=0;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_travels)



        val next=findViewById<Button>(R.id.btnNext)

        next.setOnClickListener {
            bookNext()
        }

        val book=findViewById<Button>(R.id.btnbookTravels)
        book.setOnClickListener {

            finalBook()
        }

        val receipt=findViewById<Button>(R.id.btnreceipt)
        receipt.setOnClickListener {
            val radiogrpac=findViewById<RadioGroup>(R.id.rgTravels)
            val acbtn=radiogrpac.checkedRadioButtonId
            val ac=findViewById<RadioButton>(acbtn)

            val radiogrpseating=findViewById<RadioGroup>(R.id.rgTravelsSeat)
            val seatbtn=radiogrpseating.checkedRadioButtonId
            val seating=findViewById<RadioButton>(seatbtn)

            var msg1=""
            var msg2=""
            if(ac.text=="AC"){
                 msg2="Ac : 200Rs"
            }else{
                msg2="Ac : 00.0Rs  (Non Ac)"
            }
            if(seating.text=="Sleeping  (Rs :1500)"){
                msg1="Sleeping : 1500Rs"
            }
            else{
                msg1="Seating : 1000Rs"
            }

            val intent=Intent(this,PayForTravels::class.java)
            intent.putExtra("msg1",msg1)
            intent.putExtra("msg2",msg2)
            intent.putExtra("total","Total :"+total.toString()+"Rs")
            startActivity(intent)
        }

    }

    fun bookNext(){

        val radiogrpac=findViewById<RadioGroup>(R.id.rgTravels)
        val acbtn=radiogrpac.checkedRadioButtonId
        val ac=findViewById<RadioButton>(acbtn)

        if(ac==null){
            Toast.makeText(this,"Select requirements",Toast.LENGTH_SHORT).show()
            // startActivity(Intent(this,Travels::class.java))
        }
        else if(ac.text=="AC"){
            total+=200
        }



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

        val radiogrpseating=findViewById<RadioGroup>(R.id.rgTravelsSeat)
        val seatbtn=radiogrpseating.checkedRadioButtonId
        val seating=findViewById<RadioButton>(seatbtn)

        if(seating==null){
            Toast.makeText(this,"Select requirements",Toast.LENGTH_SHORT).show()
            //  startActivity(Intent(this,Travels::class.java))
        }
        else if(seating.text=="Sleeping  (Rs :1500)"){
            total=total+1500
        }
        else
        {
            total=total+1000
        }
        val billamt=findViewById<TextView>(R.id.tvTravelsBill)
        billamt.text="Total :"+(total).toString()+"Rs"
        billamt.visibility=View.VISIBLE
        val book=findViewById<Button>(R.id.btnbookTravels)
        book.visibility=View.GONE
        val receipt=findViewById<Button>(R.id.btnreceipt)
        receipt.visibility=View.VISIBLE
    }

}
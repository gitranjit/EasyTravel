package com.example.login_register

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_book_room.*
import kotlinx.android.synthetic.main.activity_pay_for_travels.*

class PayForTravels : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pay_for_travels)

        var msg1=intent.getStringExtra("msg1")
        var msg2=intent.getStringExtra("msg2")
        var totalamt=intent.getStringExtra("total")

        val pay=findViewById<Button>(R.id.btnPayreceipt)

        val seating=findViewById<TextView>(R.id.tvSeatingReceipt)
        val ac=findViewById<TextView>(R.id.tvAcReceipt)
        val total=findViewById<TextView>(R.id.tvTotalReceipt)

        seating.text=msg1.toString()
        ac.text=msg2.toString()
        total.text=totalamt.toString()

        pay.setOnClickListener {
            Toast.makeText(this,"Payment Successful",Toast.LENGTH_SHORT).show()
            startActivity(Intent(this,Travels::class.java))
        }

    }
}
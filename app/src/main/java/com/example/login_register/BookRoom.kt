package com.example.login_register

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*

class BookRoom : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_book_room)
        val genbill=findViewById<Button>(R.id.btnGenerateBill)
        val pay=findViewById<Button>(R.id.btnPay)
        val ac_or_not=findViewById<RadioGroup>(R.id.rgAc)
        val single_or_double_bed=findViewById<RadioGroup>(R.id.rgRoom)
        var total=0

//        ac_or_not.setOnCheckedChangeListener{ac_or_not,i->
//            val ac=findViewById<RadioButton>(i)
//            if(ac.text=="AC"){
//                total =total+200
//            }
//        }
//        single_or_double_bed.setOnCheckedChangeListener{single_or_double_bed,i->
//            val room=findViewById<RadioButton>(i)
//            if(room.text=="Single Bed"){
//                total=total+500
//            }
//            else{
//                total=total+1000
//            }
//        }
        genbill.setOnClickListener {
            generateBill()
//            val reqLayout=findViewById<LinearLayout>(R.id.llrequirement)
//            reqLayout.visibility=View.GONE
//
//            val acbtn=ac_or_not.checkedRadioButtonId
//            val ac=findViewById<RadioButton>(acbtn)
//            val roombtn=single_or_double_bed.checkedRadioButtonId
//            val room=findViewById<RadioButton>(roombtn)
//
//            if(ac==null || room==null){
//                Toast.makeText(this,"Select Requrements",Toast.LENGTH_SHORT).show()
//
//            }
//
//            if(ac.text=="AC"){
//                total=total+200
//            }
//            if(room.text=="Single Bed"){
//                total=total+500
//            }
//            else{
//                total=total+1000
//            }
//            val totalbill=findViewById<TextView>(R.id.tvtotal)
//           totalbill.text="Total :"+total
//
//            val scrolview=findViewById<ScrollView>(R.id.svbill)
//            scrolview.visibility=View.VISIBLE
        }


        pay.setOnClickListener {
            Toast.makeText(this,"Payment Succefull",Toast.LENGTH_SHORT).show()
            startActivity(Intent(this,BookHotel::class.java))
        }



    }

    fun generateBill(){
        val reqLayout=findViewById<LinearLayout>(R.id.llrequirement)
        reqLayout.visibility=View.GONE

        val genbill=findViewById<Button>(R.id.btnGenerateBill)
        val pay=findViewById<Button>(R.id.btnPay)
        val ac_or_not=findViewById<RadioGroup>(R.id.rgAc)
        val single_or_double_bed=findViewById<RadioGroup>(R.id.rgRoom)
        var total=0
        val acbtn=ac_or_not.checkedRadioButtonId
        val ac=findViewById<RadioButton>(acbtn)
        val roombtn=single_or_double_bed.checkedRadioButtonId
        val room=findViewById<RadioButton>(roombtn)

        if(ac==null || room==null){
            Toast.makeText(this,"Select Requrements",Toast.LENGTH_SHORT).show()
            startActivity(Intent(this,BookRoom::class.java))
        }

        if(ac.text=="AC"){
            total=total+200

        }
        if(room.text=="Single Room (500RS per day)"){
            total=total+500
        }
        else{
            total=total+1000
        }

        when(total){
            500->{
                findViewById<TextView>(R.id.tvSwithAC).visibility=View.GONE
                findViewById<TextView>(R.id.tvDwithoutAC).visibility=View.GONE
                findViewById<TextView>(R.id.tvDwithAC).visibility=View.GONE
            }
            700->{
                findViewById<TextView>(R.id.tvSwitouthAC).visibility=View.GONE
                findViewById<TextView>(R.id.tvDwithoutAC).visibility=View.GONE
                findViewById<TextView>(R.id.tvDwithAC).visibility=View.GONE
            }
            1000->{
                findViewById<TextView>(R.id.tvSwitouthAC).visibility=View.GONE
                findViewById<TextView>(R.id.tvSwithAC).visibility=View.GONE
                findViewById<TextView>(R.id.tvDwithAC).visibility=View.GONE
            }
            1200->{
                findViewById<TextView>(R.id.tvDwithoutAC).visibility=View.GONE
                findViewById<TextView>(R.id.tvSwitouthAC).visibility=View.GONE
                findViewById<TextView>(R.id.tvSwithAC).visibility=View.GONE
            }

        }
        val totalbill=findViewById<TextView>(R.id.tvtotal)
        totalbill.text="Total :"+total+".0"

        val scrolview=findViewById<ScrollView>(R.id.svbill)
        scrolview.visibility=View.VISIBLE
    }

}
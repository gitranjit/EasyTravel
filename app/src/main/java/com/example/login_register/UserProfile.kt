package com.example.login_register

import android.content.Intent
import android.database.Cursor
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.widget.TextView
import android.widget.Toast

class UserProfile : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_profile)

        var username=findViewById<TextView>(R.id.tvUserName)
        var phone=findViewById<TextView>(R.id.tvphoneno)
        var email=findViewById<TextView>(R.id.tvEmail)
        var first=findViewById<TextView>(R.id.tvFirst)
        var last=findViewById<TextView>(R.id.tvLast)
        val mail=intent.getStringExtra("gmail").toString()
//        email.text=mail

//        var user: MutableList<String> = ArrayList()
        val db= DatabaseHandler(this)
//        user=db.readData(mail)
//
//        username.text=user[1]+" "+user[2]
//        phone.text="Phone no:"+user[3]
//        email.text="Email :"+user[1]

//        var list: MutableList<User> = ArrayList()
//        list=db.readData(mail=String())
        var user: User=User()
        user=db.readData(mail= String())
//        Toast.makeText(this,user.firstname.toString(),Toast.LENGTH_SHORT).show()

        username.text ="User Information"
        first.text="First Name : "+user.firstname
        last.text="First Name  : "+user.lastname
        phone.text="Phone no   : "+user.phone
        email.text="Email      : "+user.gmail



    }
}
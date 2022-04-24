package com.example.login_register

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import kotlin.random.Random

class ForgotPassword : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgot_password)

        val otp= Random.nextInt(1000,9999)+1;
        val otpbtn =findViewById<Button>(R.id.btnOtp)
        otpbtn.setOnClickListener {
            otpbtn.visibility= View.GONE
           val confirmpass=findViewById<EditText>(R.id.etConfirmPassword)
            confirmpass.visibility=View.VISIBLE
            val newpass=findViewById<EditText>(R.id.etNewPassword)
            newpass.visibility=View.VISIBLE
            val mail=findViewById<EditText>(R.id.etUsername)
            mail.visibility=View.GONE
            Toast.makeText(this,otp.toString(),Toast.LENGTH_LONG).show()

        }
        val changepass=findViewById<Button>(R.id.btnChangePass)
        changepass.setOnClickListener {

            Toast.makeText(this,"Password Changed",Toast.LENGTH_SHORT).show()
            startActivity(Intent(this,MainActivity::class.java))
        }
    }
}
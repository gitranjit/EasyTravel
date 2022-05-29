package com.example.login_register

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.UserHandle
import android.util.Log
import android.view.View
import android.widget.*
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuthException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.*
import com.google.firebase.ktx.Firebase
import java.lang.StringBuilder
import java.util.*

class MainActivity : AppCompatActivity() {



    private lateinit var mail:EditText
    private lateinit var pass:EditText



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mail=findViewById(R.id.etgmailinLogin)
        pass=findViewById(R.id.etpassinLogin)



    val signinbtn=findViewById<Button>(R.id.btnSignIn)
        signinbtn.setOnClickListener {


            val progressbar=findViewById<ProgressBar>(R.id.progressbar)
            progressbar.visibility= View.VISIBLE
            signinbtn.visibility=View.GONE
            Login()


        }

        val createAcc=findViewById<TextView>(R.id.tvRegister)
        createAcc.setOnClickListener {
            val intent=Intent(this,Register::class.java)
            startActivity(intent)
        }

        val forgotPass=findViewById<TextView>(R.id.tvForgotPass)
        forgotPass.setOnClickListener {
            startActivity(Intent(this,ForgotPassword::class.java))
        }
    }


    private fun Login(){

        val progressbar=findViewById<ProgressBar>(R.id.progressbar)
        val signinbtn=findViewById<Button>(R.id.btnSignIn)

            val gmail=mail.text.toString()
            val passw=pass.text.toString()



            if(gmail.isEmpty()){
                signinbtn.visibility=View.VISIBLE
                progressbar.visibility= View.GONE
                mail.error="Enter Gmail"
            }
            else if(passw.isEmpty()){
                progressbar.visibility= View.GONE
                signinbtn.visibility=View.VISIBLE
                pass.error="Enter Password"
            }
            else{
                FirebaseAuth.getInstance().signInWithEmailAndPassword(gmail,passw)
                    .addOnCompleteListener(
                        OnCompleteListener <AuthResult>{ task->
                            if(task.isSuccessful){
                                val firebsseuser : FirebaseUser =task.result!!.user!!

                                Toast.makeText(this,"Logged in successfully",Toast.LENGTH_SHORT).show()
                                progressbar.visibility= View.GONE

                                val i=Intent(this,Cities::class.java)
//                                i.putExtra(Intent.EXTRA_EMAIL,gmail)
                                i.putExtra("gmail",gmail)
                                startActivity(i)
                                finish()

                            }
                            else{
                                progressbar.visibility= View.GONE
                                signinbtn.visibility=View.VISIBLE
                                Toast.makeText(this,task.exception!!.message.toString(),Toast.LENGTH_SHORT).show()
                            }
                        }
                    )
            }

    }



}


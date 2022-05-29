package com.example.login_register

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import kotlin.random.Random

class ForgotPassword : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgot_password)


        val progressbar=findViewById<ProgressBar>(R.id.progressbar)
        val submit=findViewById<Button>(R.id.btnSubmit)
        submit.setOnClickListener {
            progressbar.visibility= View.VISIBLE
            submit.visibility=View.GONE
            val mail=findViewById<EditText>(R.id.etEmailtoResetPass)
            var email=mail.text.toString()
            if(email.isEmpty()){
                progressbar.visibility= View.GONE
                submit.visibility=View.VISIBLE
                mail.error="Enter e-mail address to receive mail"
            }
            else{
                FirebaseAuth.getInstance().sendPasswordResetEmail(email)
                    .addOnCompleteListener{task->
                        if(task.isSuccessful){
                            progressbar.visibility= View.GONE
                            Toast.makeText(this,"Email sent successfully to reset password",Toast.LENGTH_SHORT).show()

                            finish()
                        }
                        else{
                            progressbar.visibility= View.GONE
                            submit.visibility=View.VISIBLE
                            Toast.makeText(this,task.exception!!.message.toString(),Toast.LENGTH_SHORT).show()
                        }
                    }
            }
        }




    }


}
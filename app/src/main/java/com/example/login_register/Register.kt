package com.example.login_register

import android.content.ContentValues
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.renderscript.Sampler
import android.view.View
import android.widget.*
import com.google.android.gms.tasks.OnCompleteListener
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.firestore.FirebaseFirestore


class Register : AppCompatActivity() {


    private lateinit var fname:EditText
   private lateinit var lname:EditText
    private lateinit var phno:EditText
    private lateinit var gmail:EditText
    private lateinit var pass:EditText
    private lateinit var conpass:EditText


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)


        fname=findViewById(R.id.etFname)
        lname=findViewById(R.id.etLname)
        phno=findViewById(R.id.etPhNo)
        gmail=findViewById(R.id.etEmail)
        pass=findViewById(R.id.etNewPassword)
        conpass=findViewById(R.id.etConfirmPassword)



        val btnBack=findViewById<ImageButton>(R.id.btnBack)
        btnBack.setOnClickListener{

            val intent= Intent(this,MainActivity::class.java)
                    startActivity(intent)

        }
        val btnregister=findViewById<Button>(R.id.btnRegister)
        btnregister.setOnClickListener {
//            Toast.makeText(this,"Account Created",Toast.LENGTH_SHORT).show()
//            startActivity(Intent(this,Cities::class.java))

            val progressbar=findViewById<ProgressBar>(R.id.progressbar)
            progressbar.visibility= View.VISIBLE
            btnregister.visibility=View.GONE



//            startActivity(Intent(this,MainActivity::class.java))
            saveData()


        }

    }

    private fun saveData(){

        val progressbar=findViewById<ProgressBar>(R.id.progressbar)
        val btnregister=findViewById<Button>(R.id.btnRegister)

       val etfname=fname.text.toString()
       val etlname=lname.text.toString()
       val ph=phno.text.toString()
       val mail=gmail.text.toString()
       val passw=pass.text.toString()
       val cpass=conpass.text.toString()

        if(etfname.isEmpty()){
            progressbar.visibility= View.GONE
            btnregister.visibility=View.VISIBLE
            fname.error="First name is Empty"
        }
        else if(etlname.isEmpty()){
            progressbar.visibility= View.GONE
            btnregister.visibility=View.VISIBLE
            lname.error="Last name is Empty"
        }
        else if(ph.isEmpty() || ph.length<10){
            progressbar.visibility= View.GONE
            btnregister.visibility=View.VISIBLE
            phno.error="Enter valid phone no"
        }
        else if(mail.isEmpty()){
            progressbar.visibility= View.GONE
            btnregister.visibility=View.VISIBLE
            gmail.error="Gmail is Empty"
        }
        else if(passw.isEmpty()){
            progressbar.visibility= View.GONE
            btnregister.visibility=View.VISIBLE
            pass.error="Enter password "
        }
       else if(cpass.isEmpty()){
            progressbar.visibility= View.GONE
            btnregister.visibility=View.VISIBLE
            conpass.error="Enter password again to confirm"
        }
        else if(passw!=cpass){
            progressbar.visibility= View.GONE
            btnregister.visibility=View.VISIBLE
            conpass.error="Passwords are not matching"
        }

        else{



            val db=FirebaseFirestore.getInstance()
            val user:MutableMap<String,Any> =HashMap()

            user["First Name"]=etfname
            user["Last Name"]=etlname
            user["Phone no"]=ph
            user["Email"]=mail
            user["Password"]=passw



            FirebaseAuth.getInstance().createUserWithEmailAndPassword(mail,passw)
                .addOnCompleteListener(
                    OnCompleteListener <AuthResult>{task->

                        if(task.isSuccessful){
                            val firebsseuser : FirebaseUser=task.result!!.user!!

                            val dbs=DatabaseHandler(this)
                            dbs.InserData(fname.text.toString(),lname.text.toString(),phno.text.toString(),gmail.text.toString(),pass.text.toString())


                            db.collection("Users")
                                .add(user)
                                .addOnSuccessListener {
                                   Toast.makeText(this,"You Registered successfully",Toast.LENGTH_SHORT).show()
                                }.addOnFailureListener{
                                    Toast.makeText(this," Registration Failed",Toast.LENGTH_SHORT).show()
                                }

                            progressbar.visibility= View.GONE

                            startActivity(Intent(this,MainActivity::class.java))
                            finish()

                        }
                        else{

                            progressbar.visibility= View.GONE

                            btnregister.visibility=View.VISIBLE
                            Toast.makeText(this,task.exception!!.message.toString(),Toast.LENGTH_SHORT).show()
                        }
                    }
                )
        }


    }
}
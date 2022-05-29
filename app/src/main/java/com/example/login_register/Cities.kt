package com.example.login_register

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_cities.*


class Cities : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cities)

        setSupportActionBar(toolbar)

        val toggle= ActionBarDrawerToggle(this,drawerlayout,toolbar,R.string.open,R.string.close)
        toggle.isDrawerSlideAnimationEnabled=true
        drawerlayout.addDrawerListener(toggle)
        toggle.syncState()


        nav_view.setNavigationItemSelectedListener {
            when(it.itemId){
                R.id.profile-> {
                    var mail=intent.getStringExtra("gmail")
                    val i=Intent(this,UserProfile::class.java)
                    i.putExtra("gmail",mail)
                    startActivity(i)

                }

                R.id.setting->Toast.makeText(this,"Setting",Toast.LENGTH_SHORT).show()
                R.id.share->Toast.makeText(this,"Share",Toast.LENGTH_SHORT).show()
                R.id.feedback->Toast.makeText(this,"Feedback",Toast.LENGTH_SHORT).show()
                R.id.aboutus->Toast.makeText(this,"About",Toast.LENGTH_SHORT).show()
                R.id.logout->{
                    FirebaseAuth.getInstance().signOut()
                    startActivity(Intent(this,MainActivity::class.java))
                }
            }
                true
        }



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

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val toggle= ActionBarDrawerToggle(this,drawerlayout,toolbar,R.string.open,R.string.close)
        if(toggle.onOptionsItemSelected(item)){
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}



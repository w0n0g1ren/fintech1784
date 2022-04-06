package com.example.first

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.fragment.app.Fragment
import com.example.first.home.HomeFragment
import com.example.first.profile.ProfileActivity
import com.example.first.profile.ProfileFragment
import com.example.first.settings.SettingsActivity
import com.example.first.settings.SettingsFragment

class MainActivity : AppCompatActivity() {
    private lateinit var button_home : Button
    private lateinit var button_profile : Button
    private lateinit var button_settings : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button_home = findViewById(R.id.button_home)
        button_profile = findViewById(R.id.button_profile)
        button_settings = findViewById(R.id.button_settings)


        //panggil activity
//        button_home.setOnClickListener{
//            val intent =Intent(this,HomeActivity::class.java)
//            startActivity(intent)
//        }
//        button_profile.setOnClickListener{
//            val intent= Intent(this, ProfileActivity::class.java)
//            startActivity(intent)
//        }
//        button_settings.setOnClickListener{
//            val intent= Intent(this, SettingsActivity::class.java)
//            startActivity(intent)
//        }

        //panggil fragment
        button_home.setOnClickListener{
            loadfragment(HomeFragment())
        }
        button_profile.setOnClickListener{
            loadfragment(ProfileFragment())
        }
        button_settings.setOnClickListener{
            loadfragment(SettingsFragment())
        }
    }

    //function untuk mengeload fragment
    private fun loadfragment(fragment : Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.container, fragment)
            .commitNow()
    }
}
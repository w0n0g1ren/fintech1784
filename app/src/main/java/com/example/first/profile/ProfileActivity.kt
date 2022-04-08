package com.example.first.profile

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import com.example.first.R

class ProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        title = "menu profile"
        val nama = findViewById<TextView>(R.id.tvnama)
        val nim = findViewById<TextView>(R.id.tvnim)
        val email = findViewById<TextView>(R.id.tvemail)
        val nohp = findViewById<TextView>(R.id.tvhp)
        val jk = findViewById<TextView>(R.id.tvjk)
        val prodi = findViewById<TextView>(R.id.tvps)
        val org = findViewById<TextView>(R.id.tvorga)
        val status = findViewById<TextView>(R.id.tvstatus)

        val bukabundle = intent.extras
        if (bukabundle !=null){
            nama.setText(bukabundle.getString("nama"))
            nim.setText(bukabundle.getString("nim"))
            email.setText(bukabundle.getString("email"))
            nohp.setText(bukabundle.getString("nohp"))
            jk.setText(bukabundle.getString("jk"))
            prodi.setText(bukabundle.getString("prodi"))
            nama.setText(bukabundle.getString("nama"))
            org.setText(bukabundle.getString("org"))
            status.setText(bukabundle.getString("status"))
        }
    }
}
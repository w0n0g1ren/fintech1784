package com.example.first.settings

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.*
import androidx.appcompat.app.AlertDialog
import com.example.first.R
import com.example.first.profile.ProfileActivity
import java.lang.StringBuilder
import java.util.regex.Pattern

class SettingsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)

        title= "menu settings"
        val btnsave = findViewById<Button>(R.id.btsimpan)
        val nama = findViewById<EditText>(R.id.etnama)
        val nim = findViewById<EditText>(R.id.etnim)
        val email = findViewById<EditText>(R.id.etemail)
        val nohp = findViewById<EditText>(R.id.etnohp)
        val rgjk = findViewById<RadioGroup>(R.id.rg)
        val spinner = findViewById<Spinner>(R.id.spinner)
        val himmssi = findViewById<CheckBox>(R.id.himmssi)
        val amcc = findViewById<CheckBox>(R.id.amcc)
        val bem = findViewById<CheckBox>(R.id.bem)
        val tglbtn = findViewById<ToggleButton>(R.id.tglbtn)
        val pass = findViewById<EditText>(R.id.etpassword)

        btnsave.setOnClickListener {
            val cekjk = rgjk.checkedRadioButtonId
            val jk = findViewById<RadioButton>(cekjk)

            val org = StringBuilder()
            if (amcc.isChecked)
            {
                org.append ("AMCC\n")
            }
            if (bem.isChecked)
            {
                org.append ("BEM\n")
            }
            if (himmssi.isChecked)
            {
                org.append ("HIMMSSI")
            }

            val bundle = Bundle()
            bundle.putString("nama",nama.text.toString())
            bundle.putString("nim",nim.text.toString())
            bundle.putString("email",email.text.toString())
            bundle.putString("nohp",nohp.text.toString())
            bundle.putString("jk","${jk.text}")
            bundle.putString("prodi",spinner.selectedItem.toString())
            bundle.putString("org",org.toString())
            bundle.putString("status",tglbtn.text.toString())

            if(!Patterns.EMAIL_ADDRESS.matcher(email.text.toString()).matches()){
                email.error = "Masukkkan email dengan benar"
            }
            else if (pass.length()==0){
                pass.error="Password tidak boleh kosong"
            }
            else{
                val alertDialogBuilder = AlertDialog.Builder(this)
                alertDialogBuilder.setTitle("peringatan")
                alertDialogBuilder.setMessage("apakah data anda sudah benar ?")
                    .setCancelable(false)
                    .setPositiveButton("ya")
                    {
                        DialogInterface, i ->
                        val intent = Intent(this,ProfileActivity::class.java)
                        intent.putExtras(bundle)
                        startActivity(intent)
                        Toast.makeText( this,"data berhasil disimpan", Toast.LENGTH_SHORT).show()
                    }
                    .setNegativeButton("tidak")
                    {
                        DialogInterface, i ->DialogInterface.cancel()
                    }
                val alertDialog = alertDialogBuilder.create()
                alertDialog.show()
            }
        }
    }
}
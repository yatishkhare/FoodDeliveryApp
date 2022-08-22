package com.example.fooddeliveryapp

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    lateinit var etname: EditText
    lateinit var etpassword: EditText
    lateinit var btnRegister: Button
    lateinit var btnLogin: Button
    lateinit var sharedPreferences: SharedPreferences
    val SHARED_PREF_NAME = "appPref"
    val KEY_NAME = "name"
    val KEY_PASSWORD="password"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        btnRegister=findViewById(R.id.btnRegister)
        etname=findViewById(R.id.etUsername)
        etpassword=findViewById(R.id.etPassword)
        btnLogin=findViewById(R.id.btnLogin)

        sharedPreferences= getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE)

        btnRegister.setOnClickListener {
                    /*val editor = sharedPreferences.edit()
                    editor.putString(KEY_NAME,etname.toString())
                    editor.putString(KEY_PASSWORD,etpassword.toString())
                    editor.apply()*/
                    Toast.makeText(this, "Registered Successfully", Toast.LENGTH_LONG).show()

        }


        btnLogin.setOnClickListener {
            val user = sharedPreferences.getString(KEY_NAME, null)
            val password= sharedPreferences.getString(KEY_PASSWORD, null)

            if (user == etname.toString() && password == etpassword.toString() ) {
                Toast.makeText(this, "Welcome User", Toast.LENGTH_LONG).show()
                finish()

            } else {
                Toast.makeText(this, "INVALID INPUT", Toast.LENGTH_SHORT).show()
            }
        }
        }

    }

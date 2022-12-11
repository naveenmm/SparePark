package com.example.sparepark.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.sparepark.R

class LoginActivity : AppCompatActivity() {

    private lateinit var usernameField: EditText
    private lateinit var passwordField: EditText
    private lateinit var userTypeRadio: RadioGroup
    private lateinit var loginBtn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        init()
    }

    private fun init() {
        usernameField = findViewById(R.id.username)
        passwordField = findViewById(R.id.password)
        userTypeRadio = findViewById(R.id.radioGroup)
        loginBtn = findViewById(R.id.loginBtn)
        loginBtn.setOnClickListener {
            checkLoginDetails()
        }
    }

    private fun checkLoginDetails(): Boolean {
        if (usernameField.text.toString() == "" || passwordField.text.toString() == "") {
            Toast.makeText(this, "You did not enter a username/password", Toast.LENGTH_SHORT)
                .show()
            return false
        } else if (userTypeRadio.checkedRadioButtonId == -1) {
            Toast.makeText(this, "Select Owner/Finder", Toast.LENGTH_SHORT).show()
            return false
        }
        startActivity(Intent(applicationContext, MainActivity::class.java))
        return true
    }
}
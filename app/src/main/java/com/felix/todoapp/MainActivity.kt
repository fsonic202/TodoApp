 package com.felix.todoapp

import android.app.Application
import android.app.ApplicationErrorReport
import android.content.Intent
import android.content.pm.ApplicationInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

 class MainActivity : AppCompatActivity() {
    val validUsername ="admin"
    val validpassword ="admin"

    private lateinit var UsernameInput:EditText
    private lateinit var PasswordInput:EditText
    private lateinit var SubmitButton:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        UsernameInput = findViewById(R.id.UsernameInput)
        PasswordInput = findViewById(R.id.PasswordInput)
        SubmitButton = findViewById(R.id.SubmitButton)


        SubmitButton.setOnClickListener {
            val username = UsernameInput.text.toString()
            val password = PasswordInput.text.toString()

            login(username, password)
        }
    }
    private fun login(username: String, password: String){
        if(isValidCredentials(username, password)){
            val intent: Intent = Intent(this,HomeActivity::class.java)
            intent.putExtra("username",username)
            startActivity(intent)
        }else{
            Toast.makeText(applicationContext, "Please Enter Your Login Details Correctly!", Toast.LENGTH_SHORT)
                .show()
        }
    }
    private fun isValidCredentials(username: String, password: String):Boolean{
        if(username == validUsername && password == validUsername) return true
            return false
    }
}
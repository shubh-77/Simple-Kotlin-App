package com.example.mykotlinproject

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.CheckBox
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_register.*

class MainActivity : AppCompatActivity() {


    //checkbox var
    lateinit var remCreds: CheckBox

    lateinit var registerSP:SharedPreferences


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        registerSP=getSharedPreferences("myregisterfile", MODE_PRIVATE)

        //editTextEmailAddress.setText(registerSP.getString("keyusername",""))
        var registeredUsername=registerSP.getString("keyusername","")
        var registeredPassword=registerSP.getString("keypass","")







        //find checkbox by id
        remCreds=findViewById(R.id.rememberMecheckBox)

        var intent:Intent;


       rememberMecheckBox.setOnClickListener{
           if(remCreds.isChecked){
               editTextEmailAddress.setText(registerSP.getString("keyusername",""))
               editTextPassword.setText(registerSP.getString("keypass",""))
           }
           else{
               editTextEmailAddress.setText("")
               editTextPassword.setText("")
           }
       }


        buttonRegister.setOnClickListener{
            Toast.makeText(this, "Redirecting to register page", Toast.LENGTH_SHORT).show()
            val intent=Intent(this,RegisterActivity::class.java)
            startActivity(intent)

        }
        buttonLogin.setOnClickListener {

            if(editTextEmailAddress.text.isNullOrBlank()&&editTextPassword.text.isNullOrBlank()){
                Toast.makeText(this, "Please fill the required fields", Toast.LENGTH_SHORT).show()
//                var flagstr=registerSP.getString("keyusername","")
//                Toast.makeText(this,flagstr,Toast.LENGTH_LONG).show()
            }

            else{



                    var username = editTextEmailAddress.text.toString()
                    var pass=editTextPassword.text.toString()
                    if(username==registeredUsername&&pass==registeredPassword){
                        Toast.makeText(this, "${editTextEmailAddress.text}  is logged in!!", Toast.LENGTH_SHORT).show()
                        intent=Intent(this,DashboardActivity::class.java)
                        intent.putExtra("loginusername",username)



                        startActivity(intent)
                    }




            }
        }




    }
}
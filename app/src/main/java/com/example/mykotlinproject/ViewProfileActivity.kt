package com.example.mykotlinproject

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_view_profile.*

class ViewProfileActivity : AppCompatActivity() {
    lateinit var registerSP: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_profile)
        registerSP=getSharedPreferences("myregisterfile", MODE_PRIVATE)
        var registeredUsername=registerSP.getString("keyusername","")
        var registeredPassword=registerSP.getString("keypass","")
        var registeredGender=registerSP.getString("keygender","")
        var registeredVehicle=registerSP.getString("keyvehicle","")
        var registeredChoice=registerSP.getString("keychoice","")


        textViewProfile.text="Username: $registeredUsername \nPassword: $registeredPassword\nGender: $registeredGender\nVehicle:$registeredVehicle\nCountry:$registeredChoice"


    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.mymenu,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        var id =item.itemId
        if(id==R.id.logout){
            logout()
            Toast.makeText(this,"LOGGING OUT", Toast.LENGTH_LONG).show()

            return true
        }
        if(id==R.id.profile){
            viewProfile()
            Toast.makeText(this,"Profile Page", Toast.LENGTH_LONG).show()
            return true

        }

        return super.onOptionsItemSelected(item)
    }
    public fun logout(){
        val i= Intent(this,MainActivity::class.java)
        startActivity(i)
    }
    public fun viewProfile(){
        val i= Intent(this,ViewProfileActivity::class.java)
        startActivity(i)
    }




}
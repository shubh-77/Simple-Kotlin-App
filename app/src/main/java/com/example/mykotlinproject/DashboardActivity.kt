package com.example.mykotlinproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_dashboard.*

class DashboardActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        var username=intent.extras?.getString("loginusername")
        textViewDashboard.text="Hello $username"
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
        val i=Intent(this,ViewProfileActivity::class.java)
        startActivity(i)
    }


}
package com.example.mykotlinproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_display_info.*

class DisplayInfoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display_info)


        var username=intent.extras?.getString("username")
        var pass=intent.extras?.getString("pass")
        var gender=intent.extras?.getString("gender")

        var vehicle=intent.extras?.getString("vehicle")
        var choice=intent.extras?.getString("choice")

        val v=vehicle.toString()
        val v1=v.trim()






        textView.text="Received data from user:\nUSERNAME:$username\nPASSWORD:$pass\n GENDER:$gender\n Vehicle:$v1\n Choice:$choice"
        buttonGoToLogin.setOnClickListener {

            var i=Intent(this,MainActivity::class.java)
            startActivity(i)



        }
    }

}
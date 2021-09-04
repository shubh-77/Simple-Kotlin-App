package com.example.mykotlinproject

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : AppCompatActivity() {

    //Adding Shared Preferences
    lateinit var sp:SharedPreferences



    //Added for radioButton
    var radioGroup: RadioGroup? = null
    lateinit var radioButton: RadioButton;

    //added for check box
    lateinit var car: CheckBox
    lateinit var bike:CheckBox
    lateinit var agree:CheckBox




    //added for spinner
    val dropDownList= arrayOf("India","Australia","USA","England")
    lateinit var choice: String;





    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        sp=getSharedPreferences("myregisterfile", MODE_PRIVATE)





        //Variable Declaration
        var username:String;
        var pass:String;
        var gender:String;
        var vehicle:String;


        var intent:Intent;


        //Finding radiobutton by id
        radioGroup = findViewById(R.id.radioGroup)

        //finding checkbox
        car = findViewById(R.id.checkBox1)
        bike=findViewById(R.id.checkBox2)
        agree=findViewById(R.id.agreeCheckBox)

        //to store checkbox vals
        val result = StringBuilder()



        //Adapter for spinner
        val adapter=ArrayAdapter(this,android.R.layout.simple_spinner_item,dropDownList)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item)
        statusFilter.adapter=adapter
        statusFilter.onItemSelectedListener=object: AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(p0: AdapterView<*>?) {

            }
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                if (statusFilter.selectedItemPosition==0){
                    condition1()

                }
                if (statusFilter.selectedItemPosition==1){
                    condition2()
                }
                if (statusFilter.selectedItemPosition==2){
                    condition3()
                }


            }



        }







        buttonUserRegister.setOnClickListener {
            if(editTextTextEmailAddress.text.isNullOrBlank()&&editTextTextPassword.text.isNullOrBlank()){
                Toast.makeText(this, "Please fill the required fields", Toast.LENGTH_SHORT).show()
            }
            else{

                if(agree.isChecked){
                    username=editTextTextEmailAddress.text.toString();
                    pass=editTextTextPassword.text.toString();
                    //retrieve radio button value
                    val intSelectButton: Int = radioGroup!!.checkedRadioButtonId
                    radioButton = findViewById(intSelectButton)
                    gender=radioButton.text.toString();



                    //retrieve value from checkbox
                    if(car.isChecked){
                        result.append("\nYou have car ")
                    }
                    if(bike.isChecked){
                        result.append("\nYou have bike ")
                    }
                    Toast.makeText(applicationContext, result.toString(), Toast.LENGTH_SHORT).show()
                    vehicle=result.toString()


                    /*Shared preference code*/
                    var editor=sp.edit()
                    editor.putString("keyusername",username)
                    editor.putString("keypass",pass)
                    editor.putString("keygender",gender)

                    val v=vehicle
                    val v1=v.trim()
                    editor.putString("keyvehicle",v1)



                    editor.putString("keychoice",choice)

                    editor.commit()
                    editTextTextEmailAddress.setText("")
                    editTextTextPassword.setText("")






                    Toast.makeText(this, "${editTextTextEmailAddress.text}  is register in!!", Toast.LENGTH_SHORT).show()
//                val intent=Intent(this,DisplayInfoActivity::class.java)
//                startActivity(intent)
                    intent=Intent(this,DisplayInfoActivity::class.java)
                    intent.putExtra("username",username)
                    intent.putExtra("pass",pass)
                    intent.putExtra("gender",gender)
                    intent.putExtra("vehicle",vehicle)
                    intent.putExtra("choice",choice)









                    startActivity(intent)


                }
                Toast.makeText(this, "Please Accept Terms And Conditions", Toast.LENGTH_SHORT).show()

//
//                username=editTextTextEmailAddress.text.toString();
//                pass=editTextTextPassword.text.toString();
//                //retrieve radio button value
//                val intSelectButton: Int = radioGroup!!.checkedRadioButtonId
//                radioButton = findViewById(intSelectButton)
//                gender=radioButton.text.toString();
//
//
//
//                //retrieve value from checkbox
//                if(car.isChecked){
//                    result.append("\nYou have car ")
//                }
//                if(bike.isChecked){
//                    result.append("\nYou have bike ")
//                }
//                Toast.makeText(applicationContext, result.toString(), Toast.LENGTH_SHORT).show()
//                vehicle=result.toString()
//
//
//                /*Shared preference code*/
//                var editor=sp.edit()
//                editor.putString("keyusername",username)
//                editor.putString("keypass",pass)
//                editor.putString("keygender",gender)
//
//                val v=vehicle
//                val v1=v.trim()
//                editor.putString("keyvehicle",v1)
//
//
//
//                editor.putString("keychoice",choice)
//
//                editor.commit()
//                editTextTextEmailAddress.setText("")
//                editTextTextPassword.setText("")
//
//
//
//
//
//
//                Toast.makeText(this, "${editTextTextEmailAddress.text}  is register in!!", Toast.LENGTH_SHORT).show()
////                val intent=Intent(this,DisplayInfoActivity::class.java)
////                startActivity(intent)
//                intent=Intent(this,DisplayInfoActivity::class.java)
//                intent.putExtra("username",username)
//                intent.putExtra("pass",pass)
//                intent.putExtra("gender",gender)
//                intent.putExtra("vehicle",vehicle)
//                intent.putExtra("choice",choice)
//
//
//
//
//
//
//
//
//
//                startActivity(intent)



            }










        }



    }

    private fun condition1(){
        Toast.makeText(this,"Selected item: "+statusFilter.selectedItem,Toast.LENGTH_LONG).show()
        choice=statusFilter.selectedItem.toString()

    }
    private fun condition2(){
        Toast.makeText(this,"Selected item: "+statusFilter.selectedItem,Toast.LENGTH_LONG).show()
        choice=statusFilter.selectedItem.toString()

    }
    private fun condition3(){
        Toast.makeText(this,"Selected item: "+statusFilter.selectedItem,Toast.LENGTH_LONG).show()
        choice=statusFilter.selectedItem.toString()

    }


}
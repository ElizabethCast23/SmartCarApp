package dev.example.smartcarapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner

class registro_cliente : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro_cliente)

        val btnRegister: Button = findViewById(R.id.btnRegister)

//        val spnGender = findViewById<Spinner>(R.id.spnGender)
//
//        val listGender = resources.getStringArray(R.array.Genre)
//
//        val adapt = ArrayAdapter(this,android.R.layout.simple_spinner_item,listGender)
//        spnGender.adapter = adapt

        btnRegister.setOnClickListener {
            this.SendRegisterUser()
        }

    }

    private  fun SendRegisterUser(){
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }

}
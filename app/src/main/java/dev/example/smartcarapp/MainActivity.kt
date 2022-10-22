package dev.example.smartcarapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnSend: Button = findViewById(R.id.btnLogin)
        val btnRegister: Button = findViewById(R.id.btnregister)
        val e1: EditText =findViewById(R.id.etdocument)
        val p2: EditText =findViewById(R.id.etPassword)



        btnSend.setOnClickListener {
            val correo = "1"
//            val correo = "admin@mgapp.com"
//            val pass = "admin2022@"
            val pass = "2"

            if(e1.text.toString().length== 0){
                Toast.makeText(applicationContext,"No dejar casilla vacia",Toast.LENGTH_LONG).show()
            }else if(p2.text.toString().length== 0){
                Toast.makeText(applicationContext,"No dejar casilla vacia",Toast.LENGTH_LONG).show()
            }else if(p2.text.toString() == pass && e1.text.toString() == correo){
                this.SendLogin(e1.text.toString(),p2.text.toString())
            }else{
                this.SendLogin(e1.text.toString(),p2.text.toString())
//                Toast.makeText(applicationContext,"Invalid email or password",Toast.LENGTH_LONG).show()
            }
        }

        btnRegister.setOnClickListener{
            this.SendRegister()
        }


    }


    private  fun SendLogin(e1: String, p2: String){
        val intent = Intent(this, MenuActivity::class.java)
        intent.putExtra("e1",e1)
        intent.putExtra("p2",p2)
        startActivity(intent)
    }

    private fun SendRegister(){
        val intent = Intent(this, registro_cliente::class.java )
        startActivity(intent)

    }

}




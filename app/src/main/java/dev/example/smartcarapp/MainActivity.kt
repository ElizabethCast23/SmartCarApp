package dev.example.smartcarapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnSend: Button = findViewById(R.id.btnLogin)
        val btnRegister: Button = findViewById(R.id.btnRegisterUser)
        val e1: EditText =findViewById(R.id.etDocument)
        val p2: EditText =findViewById(R.id.etPassword)

        val spnType = findViewById<Spinner>(R.id.spnType)

        val list = resources.getStringArray(R.array.TypeUser)

        val adapt = ArrayAdapter(this,android.R.layout.simple_spinner_item,list)
        spnType.adapter = adapt

//        spnType.setOnItemClickListener {
//            parent, view, position, id ->
//            Toast.makeText( applicationContext, "$position", Toast.LENGTH_LONG).show()
//
//        }


//        Funcional

        btnSend.setOnClickListener {
            val PassUser = "1"
            val DniUser = "1"
            val PassAdm = "2"
            val DniAdm = "2"

            if(e1.text.toString().length== 0){
                Toast.makeText(applicationContext,"No dejar casilla vacia",Toast.LENGTH_LONG).show()
            }else if(p2.text.toString().length== 0) {
                Toast.makeText(applicationContext, "No dejar casilla vacia", Toast.LENGTH_LONG)
                    .show()
            }else if(p2.text.toString() == PassUser.toString() && e1.text.toString() == DniUser.toString()){
                this.SendLoginUser(e1.text.toString(),p2.text.toString())
            }else if(p2.text.toString() == PassAdm.toString() && e1.text.toString() == DniAdm.toString()){
                this.SendLoginAdm(e1.text.toString(),p2.text.toString())
            }else{
                Toast.makeText(applicationContext,"Invalid email or password",Toast.LENGTH_LONG).show()
            }
        }


        btnRegister.setOnClickListener{
            this.SendRegister()
        }
    }


    private  fun SendLoginUser(e1: String, p2: String){
        val intent = Intent(this, MenuActivityUser::class.java)
        intent.putExtra("e1",e1)
        intent.putExtra("p2",p2)
        startActivity(intent)
    }

//    FALTA
    private  fun SendLoginAdm(e1: String, p2: String){
        val intent = Intent(this, MenuActivityAdm::class.java)
        intent.putExtra("e1",e1)
        intent.putExtra("p2",p2)
        startActivity(intent)
    }

    private fun SendRegister(){
        val intent = Intent(this, registro_cliente::class.java )
        startActivity(intent)

    }

}




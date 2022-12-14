package dev.example.smartcarapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import com.google.firebase.firestore.FirebaseFirestore
import dev.example.smartcarapp.model.usuario
import java.util.*

class registro_cliente : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro_user)

        val btnRegister: Button = findViewById(R.id.btnRegister)

        val txtName: EditText = findViewById(R.id.etName)
        val txtApell: EditText = findViewById(R.id.etName2)
        val txtDNI: EditText = findViewById(R.id.etnombre)
        val txtTel: EditText = findViewById(R.id.etPhone)
        val txtEma: EditText = findViewById(R.id.etName5)
        val txtContra: EditText = findViewById(R.id.etApell)

        val db = FirebaseFirestore.getInstance()


        btnRegister.setOnClickListener {
            /*this.SendRegisterUser()*/
            val nombre = txtName.text.toString()
            val apellido = txtApell.text.toString()
            val dNI = txtDNI.text.toString()
            val tel = txtTel.text.toString()
            val email = txtEma.text.toString()
            val contra = txtContra.text.toString()


            val nuevoNombre = usuario(apellido,contra,contra,email,dNI,"",nombre,tel)
            /*val nuevoApellido = txtApell.text.toString()
            val nuevoDNI = txtDNI.text.toString()
            val nuevoTel = txtTel.text.toString()
            val nuevoEma = txtEma.text.toString()
            val nuevoContra = txtContra.text.toString()*/
            val id: UUID = UUID.randomUUID()

            db.collection("usuario")
                .document(id.toString())
                .set(nuevoNombre)
                .addOnSuccessListener {
                    correcto()
                }

        }

    }

    private fun correcto(){
        Toast.makeText(applicationContext,"Correct",Toast.LENGTH_LONG).show()
    }
/*
    private  fun SendRegisterUser(){
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }*/

}
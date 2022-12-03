package dev.example.smartcarapp.fragmentAdm

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.firestore.FirebaseFirestore
import dev.example.smartcarapp.R
import dev.example.smartcarapp.model.bus
import dev.example.smartcarapp.model.ruta
import java.util.*
import android.content.Intent

class AdmRegisterRoute : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view: View = inflater.inflate(R.layout.fragment_adm_register_route, container, false)
        val btnPreviewView: Button = view.findViewById(R.id.btnRetornRegisterRoute)
        val btnCreateBus: Button = view.findViewById(R.id.btnCreateBus)


        val txtCod: EditText = view.findViewById(R.id.codigoruta)
        val Dest: EditText = view.findViewById(R.id.destino)
        val txtSalida: EditText = view.findViewById(R.id.salida)
        val txtPrecio: EditText = view.findViewById(R.id.precio)

//        val num1 = intent.getIntExtra("txtPrecio",0)


        val db = FirebaseFirestore.getInstance()

        btnPreviewView.setOnClickListener {
            val fragment = DashboardAdm()
            val transaction = fragmentManager?.beginTransaction()
            transaction?.replace(R.id.nav_host_fragment_activity_menu_adm,fragment)?.commit()
        }


        btnCreateBus.setOnClickListener {
            val codigo = txtCod.text.toString()
            val destino = Dest.text.toString()
            val salida = txtSalida.text.toString()
            val precio = txtPrecio.text.toString()

            val nuevoRuta = ruta(codigo,destino,precio,salida)
            val id: UUID = UUID.randomUUID()

//            enviarMensaje(view, "paso")
            db.collection("ruta")
                .document(id.toString())
                .set(nuevoRuta)
                .addOnSuccessListener {
                    enviarMensaje(view, "Registro Correcto")
                }.addOnFailureListener {
                    enviarMensaje(view, "Registro INCOMPLETO")
                }

            enviarMensaje(view,"paso")

        }



        return view
    }

    private fun enviarMensaje(view: View, mensaje: String) {
        Snackbar.make(view, mensaje, Snackbar.LENGTH_LONG).show()
    }

}
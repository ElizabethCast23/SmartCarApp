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
import java.util.*

class AdmRegisterBus : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view: View =   inflater.inflate(R.layout.fragment_adm_register_bus, container, false)
        val btnPreviewView: Button = view.findViewById(R.id.btnRetornRegisterBus)
        val btnCreate: Button = view.findViewById(R.id.btnCreateBus)

        val txtPlaca: EditText = view.findViewById(R.id.placa)
        val numAño: EditText = view.findViewById(R.id.tiempo)
        val txtModelo: EditText = view.findViewById(R.id.modelo)
        val txtColor: EditText = view.findViewById(R.id.color)
        val txtNumPasaje: EditText = view.findViewById(R.id.numPasaje)


        val db = FirebaseFirestore.getInstance()

        btnPreviewView.setOnClickListener {
            val fragment = DashboardAdm()
            val transaction = fragmentManager?.beginTransaction()
            transaction?.replace(R.id.nav_host_fragment_activity_menu_adm,fragment)?.commit()
        }

        btnCreate.setOnClickListener {
            val placa = txtPlaca.text.toString()
            val tiempo = numAño.text.toString()
            val modelo = txtModelo.text.toString()
            val color = txtColor.text.toString()
            val num = txtNumPasaje.text.toString()

            val nuevoBus = bus(color,tiempo,modelo,num,placa)
            val id: UUID = UUID.randomUUID()

//            enviarMensaje(view, "paso")
            db.collection("bus")
                .document(id.toString())
                .set(nuevoBus)
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
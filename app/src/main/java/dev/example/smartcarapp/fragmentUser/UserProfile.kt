package dev.example.smartcarapp.fragmentUser

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import com.google.firebase.firestore.DocumentChange
import com.google.firebase.firestore.FirebaseFirestore
import dev.example.smartcarapp.R


class UserProfile : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view: View = inflater.inflate(R.layout.fragment_profile_user,container,false)
        val db = FirebaseFirestore.getInstance()
        val tvNombre: TextView = view.findViewById(R.id.tvNombre)
        val tvApellido: TextView = view.findViewById(R.id.tvApellido)
        val tvDNI: TextView = view.findViewById(R.id.tvDNI)
        val tvTelefono: TextView = view.findViewById(R.id.tvTelefono)
        val tvEmail: TextView = view.findViewById(R.id.tvEmail)
        db.collection("usuario")

            .addSnapshotListener {snapshots, e ->
                if(e !=null){
                    Log.w( "Firebase", "listen:error", e)
                    return@addSnapshotListener
                }
                for (dc in snapshots!!.documentChanges){
                    when (dc.type) {
                        DocumentChange.Type.ADDED -> {
                            Log.d("Firebase", "data: " + dc.document.data)
                            tvNombre.text = dc.document.data["nombre"].toString()
                            tvApellido.text = dc.document.data["apellido"].toString()
                            tvDNI.text = dc.document.data["documento"].toString()
                            tvTelefono.text = dc.document.data["tel_cel"].toString()
                            tvEmail.text = dc.document.data["correo"].toString()
                        }
                        DocumentChange.Type.MODIFIED -> {
                            tvNombre.text = dc.document.data["nombre"].toString()
                            tvApellido.text = dc.document.data["apellido"].toString()
                            tvDNI.text = dc.document.data["documento"].toString()
                            tvTelefono.text = dc.document.data["tel_cel"].toString()
                            tvEmail.text = dc.document.data["correo"].toString()

                        }
                        else ->{
                            Log.e("Firebase", "Error in Document")
                        }
                    }
                }
            }

        val btnPreviewView: Button = view.findViewById(R.id.btnGuardar_dashboard_user)
        val btnPreviewView2: Button = view.findViewById(R.id.btnCerrar_dashboard_user)

        btnPreviewView.setOnClickListener {
            val fragment = UserEditarProfile()
            val transaction = fragmentManager?.beginTransaction()
            transaction?.replace(R.id.nav_host_fragment_activity_menu, fragment)?.commit()
        }

        btnPreviewView2.setOnClickListener {
            val fragment = dashboard()
            val transaction = fragmentManager?.beginTransaction()
            //this.logout()
        }
        return view
    }
/*
    private fun logout() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)

    }
*/

}
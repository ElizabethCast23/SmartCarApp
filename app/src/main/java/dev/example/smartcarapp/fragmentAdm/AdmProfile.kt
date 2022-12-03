package dev.example.smartcarapp.fragmentAdm

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.google.firebase.firestore.DocumentChange
import com.google.firebase.firestore.FirebaseFirestore
import dev.example.smartcarapp.R
import dev.example.smartcarapp.fragmentUser.UserEditarProfile
import dev.example.smartcarapp.fragmentUser.dashboard


class AdmProfile : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view: View = inflater.inflate(R.layout.fragment_adm_profile,container,false)
        val db = FirebaseFirestore.getInstance()
        val txtNombre2: TextView = view.findViewById(R.id.etNombreDashboard_Adm)
        val txtApellido2: TextView = view.findViewById(R.id.etApellidoDashboard_Adm)
        val txtDNI2: TextView = view.findViewById(R.id.etDniDashboard_Adm)
        val txtTelefono2: TextView = view.findViewById(R.id.etTelefonoDashboard_Adm)
        val txtEmail2: TextView = view.findViewById(R.id.etEmailDashboard_Adm)

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
                            txtNombre2.text = dc.document.data["nombre"].toString()
                            txtApellido2.text = dc.document.data["apellido"].toString()
                            txtDNI2.text = dc.document.data["documento"].toString()
                            txtTelefono2.text = dc.document.data["tel_cel"].toString()
                            txtEmail2.text = dc.document.data["correo"].toString()
                        }
                        DocumentChange.Type.MODIFIED -> {
                            txtNombre2.text = dc.document.data["nombre"].toString()
                            txtApellido2.text = dc.document.data["apellido"].toString()
                            txtDNI2.text = dc.document.data["documento"].toString()
                            txtTelefono2.text = dc.document.data["tel_cel"].toString()
                            txtEmail2.text = dc.document.data["correo"].toString()

                        }
                        else ->{
                            Log.e("Firebase", "Error in Document")
                        }
                    }
                }
            }

        val btnPreviewView: Button = view.findViewById(R.id.btnGuardar_dashboard_user)
        val btnPreviewView2: Button = view.findViewById(R.id.btnCerrar_dashboard_user)

      /*  btnPreviewView.setOnClickListener {
            val fragment = UserEditarProfile()
            val transaction = fragmentManager?.beginTransaction()
            transaction?.replace(R.id.nav_host_fragment_activity_menu, fragment)?.commit()
        }
*/
        btnPreviewView2.setOnClickListener {
            val fragment = dashboard()
            val transaction = fragmentManager?.beginTransaction()
            //this.logout()
        }
        return view
    }
}



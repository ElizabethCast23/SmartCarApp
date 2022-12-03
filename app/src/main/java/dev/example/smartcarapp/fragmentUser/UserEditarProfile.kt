package dev.example.smartcarapp.fragmentUser

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import com.google.firebase.firestore.FirebaseFirestore
import dev.example.smartcarapp.R


class UserEditarProfile : Fragment() {

    private val db = FirebaseFirestore.getInstance()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view: View = inflater.inflate(R.layout.fragment_user_editar_profile, container, false)
        return inflater.inflate(R.layout.fragment_user_editar_profile, container, false)

        val txtNombre: EditText = view.findViewById(R.id.etNombreDashboard_User_editar_profile)
        val txtApellido: EditText = view.findViewById(R.id.etApellidoDashboard_User_editar_profile)
        val txtDNI: EditText = view.findViewById(R.id.etDniDashboard_User_editar_profile)
        val txtTelefono: EditText = view.findViewById(R.id.etTelefonoDashboard_User_editar_profile)
        val txtEmail: EditText = view.findViewById(R.id.etEmailDashboard_User_editar_profile)
        val btnSave: Button = view.findViewById(R.id.btnGuardar_dash_user)
        val db = FirebaseFirestore.getInstance()

        /*db.collection("usuario")
            .addSnapshotListener{snap, e->
                if(e!=null){
                    Log.e("Firebase error", "Error")
                    return@addSnapshotListener
            }
            for(dc in snap!!.documentChanges){
                when(dc.type){
                    DocumentChange.Type.MODIFIED
            }
*/
        /* btnSave.setOnClickListener{
            db.collection("usuario").document(txtDNI).set(hashMapOf("apellido" to txtApellido, "nombre" to txtNombre, "documento" to txtDNI, "tel_cel" to txtTelefono, "correo" to txtEmail))
            db
            val nombre = txtNombre.text.toString()
            val apellido = txtApellido.text.toString()
            val dni = txtDNI.text.toString()
            val telefono = txtTelefono.text.toString()
            val email = txtEmail.text.toString()*/
    }


}


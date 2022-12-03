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
import dev.example.smartcarapp.fragmentUser.UserBuscarPaquetes
import dev.example.smartcarapp.model.administrador
import dev.example.smartcarapp.model.usuario
import java.util.*


class AdmRegisterAdm : Fragment() {
  override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

      val view: View =   inflater.inflate(R.layout.fragment_adm_register_adm, container, false)

      val txtName: EditText = view.findViewById(R.id.etnombre)
      val txtApell: EditText = view.findViewById(R.id.etApell)
      val txtDNI: EditText = view.findViewById(R.id.etDNI)
      val txtCorreo: EditText = view.findViewById(R.id.etCorre)
      val txtContra: EditText = view.findViewById(R.id.etDNI)

      val db = FirebaseFirestore.getInstance()


      val btnRegister: Button = view.findViewById(R.id.btnSaveAdm)
      val btnPreviewView: Button = view.findViewById(R.id.ReturnADM)

      btnPreviewView.setOnClickListener {
          val fragment = UserBuscarPaquetes()
          val transaction = fragmentManager?.beginTransaction()
          transaction?.replace(R.id.nav_host_fragment_activity_menu, fragment)?.commit()
      }

      btnRegister.setOnClickListener {
          val name = txtName.text.toString()
          val ape = txtApell.text.toString()
          val dni = txtDNI.text.toString()
          val correo = txtCorreo.text.toString()
          val contra = txtContra.text.toString()

          val nuevoUser = administrador(ape, contra, contra, correo, dni, "", name, "")
          val id: UUID = UUID.randomUUID()

//            enviarMensaje(view, "paso")
          db.collection("administrador")
              .document(id.toString())
              .set(nuevoUser)
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
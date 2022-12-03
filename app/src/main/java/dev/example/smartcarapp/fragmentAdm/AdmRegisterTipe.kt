package dev.example.smartcarapp.fragmentAdm

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import dev.example.smartcarapp.R


class AdmRegisterTipe : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.fragment_adm_register_tipe, container, false)

        val btnRegisterUser: Button = view.findViewById(R.id.btnRegitUser)
        val btnRegisAdm: Button = view.findViewById(R.id.btnAdmReg)

        btnRegisterUser.setOnClickListener {
            val fragment = AdmRegisterUser()
            val transaction = fragmentManager?.beginTransaction()
            transaction?.replace(R.id.nav_host_fragment_activity_menu_adm,fragment)?.commit()
        }

        btnRegisAdm.setOnClickListener {
            val fragment = AdmRegisterAdm()
            val transaction = fragmentManager?.beginTransaction()
            transaction?.replace(R.id.nav_host_fragment_activity_menu_adm,fragment)?.commit()
        }


        return view

    }


}
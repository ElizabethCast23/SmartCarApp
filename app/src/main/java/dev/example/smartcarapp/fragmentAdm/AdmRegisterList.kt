package dev.example.smartcarapp.fragmentAdm

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import dev.example.smartcarapp.R


class AdmRegisterList : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view: View = inflater.inflate(R.layout.fragment_adm_register_list, container, false)
        val btnRetornRegister: Button = view.findViewById(R.id.btnRetornRegister)
        val btnRegPackage: Button = view.findViewById(R.id.btnRegPackage)
        val btnRegUser: Button = view.findViewById(R.id.btnRegUsuario)
        val btnRegRoute: Button = view.findViewById(R.id.btnRegRoute)
        val btnRegBus: Button = view.findViewById(R.id.btnRegBus)

        btnRetornRegister.setOnClickListener {
            val fragment = DashboardAdm()
            val transaction = fragmentManager?.beginTransaction()
            transaction?.replace(R.id.nav_host_fragment_activity_menu_adm,fragment)?.commit()
        }

        btnRegPackage.setOnClickListener {
            val fragment = AdmRegisterPackage()
            val transaction = fragmentManager?.beginTransaction()
            transaction?.replace(R.id.nav_host_fragment_activity_menu_adm,fragment)?.commit()
        }

        btnRegRoute.setOnClickListener {
            val fragment = AdmRegisterRoute()
            val transaction = fragmentManager?.beginTransaction()
            transaction?.replace(R.id.nav_host_fragment_activity_menu_adm,fragment)?.commit()
        }

        btnRegBus.setOnClickListener {
            val fragment = AdmRegisterBus()
            val transaction = fragmentManager?.beginTransaction()
            transaction?.replace(R.id.nav_host_fragment_activity_menu_adm,fragment)?.commit()
        }


        btnRegUser.setOnClickListener {
            val fragment = AdmRegisterTipe()
            val transaction = fragmentManager?.beginTransaction()
            transaction?.replace(R.id.nav_host_fragment_activity_menu_adm,fragment)?.commit()
        }


        return view
    }


}
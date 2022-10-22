package dev.example.smartcarapp.fragmentAdm

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import dev.example.smartcarapp.MenuActivityUser
import dev.example.smartcarapp.R

class DashboardAdm : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
//        return inflater.inflate(R.layout.fragment_adm_dashboard, container, false)
        val view: View = inflater.inflate(R.layout.fragment_adm_dashboard, container, false)
        val btnReportAdm: Button = view.findViewById(R.id.btnReportAdm)
        val btnRegisterAdm: Button = view.findViewById(R.id.btnRegisterAdm)

        btnRegisterAdm.setOnClickListener {
            val fragment = AdmRegisterList()
            val transaction = fragmentManager?.beginTransaction()
            transaction?.replace(R.id.nav_host_fragment_activity_menu_adm,fragment)?.commit()
        }



        return view




    }


}
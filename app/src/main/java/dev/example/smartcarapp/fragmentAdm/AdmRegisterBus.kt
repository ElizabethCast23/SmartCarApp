package dev.example.smartcarapp.fragmentAdm

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import dev.example.smartcarapp.R

class AdmRegisterBus : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view: View =   inflater.inflate(R.layout.fragment_adm_register_bus, container, false)
        val btnPreviewView: Button = view.findViewById(R.id.btnRetornRegisterBus)



        btnPreviewView.setOnClickListener {
            val fragment = DashboardAdm()
            val transaction = fragmentManager?.beginTransaction()
            transaction?.replace(R.id.nav_host_fragment_activity_menu_adm,fragment)?.commit()
        }

        return view
    }

}
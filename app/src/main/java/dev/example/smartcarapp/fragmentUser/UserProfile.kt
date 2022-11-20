package dev.example.smartcarapp.fragmentUser

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import dev.example.smartcarapp.MainActivity
import dev.example.smartcarapp.R


class UserProfile : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view: View = inflater.inflate(R.layout.fragment_profile_user, container, false)
        val btnPreviewView: Button = view.findViewById(R.id.btnEditar_dashboard_user)
        val btnPreviewView2: Button = view.findViewById(R.id.btnCerrar_dashboard_user)

        btnPreviewView.setOnClickListener {
            val fragment = UserEditarProfile()
            val transaction = fragmentManager?.beginTransaction()
            transaction?.replace(R.id.nav_host_fragment_activity_menu, fragment)?.commit()
        }

        btnPreviewView2.setOnClickListener {
            val fragment = dashboard()
            val transaction = fragmentManager?.beginTransaction()
            transaction?.replace(R.id.nav_host_fragment_activity_menu, fragment)?.commit()
        }
        return view
    }
}
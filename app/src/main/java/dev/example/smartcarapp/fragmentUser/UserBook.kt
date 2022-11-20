package dev.example.smartcarapp.fragmentUser

import android.app.DatePickerDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import dev.example.smartcarapp.R
import dev.example.smartcarapp.fragmentAdm.DashboardAdm
import java.util.*


class BookUser : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {

        val view: View = inflater.inflate(R.layout.fragment_book_user, container, false)
        val btnPreviewView: Button = view.findViewById(R.id.btnBuscarpaqueteBook_User)


        btnPreviewView.setOnClickListener {
            val fragment = UserBuscarPaquetes()
            val transaction = fragmentManager?.beginTransaction()
            transaction?.replace(R.id.nav_host_fragment_activity_menu, fragment)?.commit()
        }

        return view
    }
}


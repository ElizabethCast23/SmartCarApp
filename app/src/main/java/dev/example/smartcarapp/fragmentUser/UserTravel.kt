package dev.example.smartcarapp.fragmentUser

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TableRow
import android.widget.TextView
import dev.example.smartcarapp.R


class Viajes : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
//        setupTable()
        return inflater.inflate(R.layout.fragment_travel_user, container, false)
    }




}
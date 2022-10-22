package dev.example.smartcarapp

import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import dev.example.smartcarapp.databinding.ActivityMenuAdmBinding
import dev.example.smartcarapp.fragmentAdm.DashboardAdm

class MenuActivityAdm : AppCompatActivity() {

    private lateinit var binding: ActivityMenuAdmBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMenuAdmBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        supportFragmentManager.beginTransaction().replace(R.id.nav_host_fragment_activity_menu_adm,
//            DashboardAdm()).commit()

        val navView: BottomNavigationView = binding.navView

        val navController = findNavController(R.id.nav_host_fragment_activity_menu_adm)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.NavUserProfile, R.id.NavDashboard, R.id.NavTravel, R.id.NavBookUser
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
    }
}
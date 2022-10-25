package dev.example.smartcarapp

import android.os.Bundle
import android.widget.Spinner
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import dev.example.smartcarapp.databinding.ActivityMenuUserBinding

class MenuActivityUser : AppCompatActivity() {

    private lateinit var binding: ActivityMenuUserBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMenuUserBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navView: BottomNavigationView = binding.navView
        val spnType = findViewById<Spinner>(R.id.spnType)

        val navController = findNavController(R.id.nav_host_fragment_activity_menu)

        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.NavDashboard, R.id.NavTravel, R.id.NavUserProfile, R.id.NavBookUser
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
    }
}
package com.max.nlpcpodcast

import android.annotation.SuppressLint
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.Window
import android.view.WindowManager
import androidx.core.content.ContextCompat
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    @SuppressLint("ObsoleteSdkInt")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        if (Build.VERSION.SDK_INT >= 23){
            val window=this.window
            window!!.decorView.systemUiVisibility=View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR

        }
        setContentView(R.layout.activity_main)


        val  navHostFragment =supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController

        val bottomNavigationView=findViewById<BottomNavigationView>(R.id.bottomNavigation)
            bottomNavigationView.setupWithNavController(navController)

        navController.addOnDestinationChangedListener{_, screen, _ ->
            if(screen.id == R.id.signUpFragment ||screen.id==R.id.logInFragment ||screen.id== R.id.profileFragment || screen.id==R.id.forgotPasswordFragment){
                bottomNavigationView.visibility=View.GONE
            }
            else{
                bottomNavigationView.visibility=View.VISIBLE
            }
        }
    }

}
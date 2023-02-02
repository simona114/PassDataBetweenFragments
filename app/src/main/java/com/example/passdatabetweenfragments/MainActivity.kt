package com.example.passdatabetweenfragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.fragment.NavHostFragment
import com.example.passdatabetweenfragments.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
//
//        val navHostFragment =
//            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
//        val navController = navHostFragment.navController


        val fragmentTransaction = supportFragmentManager.beginTransaction()
        val fragment = FirstFragment()
        val bundle = Bundle()
        bundle.putInt("myValue", 55)
        fragment.arguments = bundle
        fragmentTransaction.replace(R.id.nav_host_fragment, fragment).commit()

    }
}
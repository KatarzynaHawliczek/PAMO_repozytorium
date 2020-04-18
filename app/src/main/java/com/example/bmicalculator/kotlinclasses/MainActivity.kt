package com.example.bmicalculator.kotlinclasses

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.bmicalculator.R
import com.google.android.material.bottomnavigation.BottomNavigationView


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val bottomNav = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        bottomNav.setOnNavigationItemSelectedListener(navigationListener)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction().replace(R.id.fragment_container,
                    StartFragment()).commit()
        }
    }

    private val navigationListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->

        var selectedFragment: Fragment? = null

        when (item.itemId) {
            R.id.bmiNav -> selectedFragment = BmiFragment()
            R.id.caloriesNav -> selectedFragment = CaloriesFragment()
            R.id.foodNav -> selectedFragment = FoodFragment()
            R.id.quizNav -> selectedFragment = QuizFragment()
            R.id.statNav -> selectedFragment = StatisticFragment()
        }

        supportFragmentManager.beginTransaction().replace(R.id.fragment_container,
                selectedFragment!!).commit()
        true
    }
}

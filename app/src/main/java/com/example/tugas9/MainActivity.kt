package com.example.tugas9

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView
import android.widget.Toast
import androidx.viewpager2.widget.ViewPager2
import com.example.tugas9.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {
    lateinit var mediator: TabLayoutMediator
    lateinit var viewPager2: ViewPager2
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        title = "Dashboard"
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        with(binding) {
            viewPager2 = viewPager
            viewPager.adapter = TabAdapter(
                supportFragmentManager, this@MainActivity.lifecycle
            )
            mediator = TabLayoutMediator(tabLayout, viewPager)
            { tab, position ->
                when (position) {
                    0 -> tab.text = "Login"
                    1 -> tab.text = "Signup"
                }
            }
            mediator.attach()
        }

    }

}
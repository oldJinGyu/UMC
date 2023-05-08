package com.example.mission6

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mission6.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var viewBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        supportFragmentManager
            .beginTransaction()
            .replace(viewBinding.mainFrame.id, SecondFragment())
            .commitAllowingStateLoss()

        viewBinding.bottomNavigationView.setOnItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.person -> {
                    supportFragmentManager
                        .beginTransaction()
                        .replace(viewBinding.mainFrame.id, FirstFragment())
                        .commitAllowingStateLoss()
                    true
                }
                R.id.home -> {
                    supportFragmentManager
                        .beginTransaction()
                        .replace(viewBinding.mainFrame.id, SecondFragment())
                        .commitAllowingStateLoss()
                    true
                }
                R.id.fire -> {
                    supportFragmentManager
                        .beginTransaction()
                        .replace(viewBinding.mainFrame.id, ThirdFragment())
                        .commitAllowingStateLoss()
                    true
                }
                else -> false
            }
        }
        viewBinding.bottomNavigationView.selectedItemId = R.id.home
    }
}
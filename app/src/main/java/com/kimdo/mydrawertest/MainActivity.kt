package com.kimdo.mydrawertest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.core.view.GravityCompat
import com.google.android.material.navigation.NavigationView
import com.kimdo.mydrawertest.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater)}
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView( binding.root  )

        setSupportActionBar( binding.toolbar )
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_baseline_navigation_24)
        supportActionBar?.setDisplayShowTitleEnabled( false )

        binding.navigationView.setNavigationItemSelectedListener( this )

        binding.mainDrawer.openDrawer(GravityCompat.START)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item!!.itemId) {
            android.R.id.home -> {
                binding.mainDrawer.openDrawer(GravityCompat.START)
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when ( item.itemId) {
            R.id.menu_item1 -> {
                Toast.makeText(this, "menu1", Toast.LENGTH_SHORT).show()
                binding.mainDrawer.closeDrawer(GravityCompat.START)
            }
            R.id.menu_item2 -> Toast.makeText(this, "menu2", Toast.LENGTH_SHORT).show()
            R.id.menu_item3 -> Toast.makeText(this, "menu3", Toast.LENGTH_SHORT).show()
        }

        return false
    }
}
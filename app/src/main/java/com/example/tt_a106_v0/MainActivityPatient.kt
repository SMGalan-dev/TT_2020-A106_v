package com.example.tt_a106_v0

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.example.tt_a106_v0.patient_fragments.GlucometerFragment
import com.example.tt_a106_v0.patient_fragments.HomeFragmentPatient
import com.google.android.material.navigation.NavigationView

class MainActivityPatient : AppCompatActivity() {

    private lateinit var toogle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_patient)

        val drawerLayout: DrawerLayout = findViewById(R.id.drawerLayoutPatient)
        toogle = ActionBarDrawerToggle(this, drawerLayout, R.string.open_drawer, R.string.close_drawer)
        drawerLayout.addDrawerListener(toogle)
        toogle.syncState()  //Sincroniza entre el icono del menu y el panel de navegacion

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val nav_view: NavigationView = findViewById(R.id.nav_viewPatient)
        nav_view.setNavigationItemSelectedListener {
            when(it.itemId){
                R.id.nav_homePatient -> {
                    supportFragmentManager.beginTransaction().apply {
                        replace(R.id.fragmentContainerView_patient, HomeFragmentPatient())
                        commit()
                    }
                }
                R.id.nav_dispGlucometer -> {
                    supportFragmentManager.beginTransaction().apply {
                        replace(R.id.fragmentContainerView_patient, GlucometerFragment())
                        commit()
                    }
                }
            }
            drawerLayout.closeDrawer(GravityCompat.START)
            true
        }
    }

    //Funcione el icono del menu
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (toogle.onOptionsItemSelected(item)){
            return true
        }
        return super.onOptionsItemSelected(item)
    }


}
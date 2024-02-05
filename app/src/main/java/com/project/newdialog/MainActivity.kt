package com.project.newdialog

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ListView
import androidx.appcompat.widget.Toolbar
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout
import com.project.newdialog.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        createDrawerNavigation()
    }

    private fun createDrawerNavigation() {
        val mDrawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        val mDrawerList: ListView = findViewById(R.id.drawer_list)
        val drawerItems: MutableList<String> = mutableListOf(
            "Item 1",
            "Item 2"
        )

        val adapter: DrawerListAdapter = DrawerListAdapter(
            this, R.layout.drawer_list_item, drawerItems)
        mDrawerList.adapter = adapter

        mDrawerList.setOnItemClickListener { parent, view, position, id ->
            // Обработка нажатий на элементы Navigation Drawer
            // Здесь можно добавить код для обработки нажатий на пункты меню
            // Например, переход на другую активность или выполнение определенных действий

            when (position) {}

        }


        // region Toolbar

        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        val actionBar: ActionBar? = supportActionBar
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true)
            actionBar.setHomeButtonEnabled(true)
        }

        val toggle: ActionBarDrawerToggle = ActionBarDrawerToggle(
            this, mDrawerLayout,
            toolbar,
            R.string.navigation_drawer_open,
            R.string.navigation_drawer_close
        )
        mDrawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        // endregion

    }



}
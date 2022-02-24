package com.huangetech.materialtest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.recyclerview.widget.GridLayoutManager
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    val fruits= mutableListOf(
        Fruit("Apple",R.drawable.apple),
        Fruit("Apple",R.drawable.apple),
        Fruit("Apple",R.drawable.apple),
        Fruit("Apple",R.drawable.apple),
        Fruit("Apple",R.drawable.apple),
        Fruit("Apple",R.drawable.apple),
        Fruit("Apple",R.drawable.apple),
        Fruit("Apple",R.drawable.apple),
        Fruit("Apple",R.drawable.apple),
        Fruit("Apple",R.drawable.apple)
    )
    val fruitList=ArrayList<Fruit>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        supportActionBar?.let {
//            让导航按钮显示
            it.setDisplayHomeAsUpEnabled(true)
//            给导航按钮设置图标
            it.setHomeAsUpIndicator(R.drawable.ic_menu)
        }
        navView.setCheckedItem(R.id.navCall)
        navView.setNavigationItemSelectedListener {
            drawerLayout.closeDrawers()
            true
        }

        fab.setOnClickListener {view->
            Snackbar.make(view,"数据已删除",Snackbar.LENGTH_SHORT)
                .setAction("撤销"){
                    Toast.makeText(this,"数据已恢复",Toast.LENGTH_SHORT).show()
                }.show()
        }

        initFruits()
        val layoutManager=GridLayoutManager(this,2)
        recyclerView.layoutManager=layoutManager
        val adapter=FruitAdapter(this,fruitList)
        recyclerView.adapter=adapter
    }

    private fun initFruits() {
        fruitList.clear()
        repeat(50){
            val index=(0 until fruits.size).random()
            fruitList.add(fruits[index])
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.toolbar,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            android.R.id.home->drawerLayout.openDrawer(GravityCompat.START)
            R.id.backup-> Toast.makeText(this,"你点击了备份",
                Toast.LENGTH_SHORT).show()
            R.id.delete-> Toast.makeText(this,"你点击了删除",
                Toast.LENGTH_SHORT).show()
            R.id.settings-> Toast.makeText(this,"你点击了设置",
                Toast.LENGTH_SHORT).show()
        }
        return true
    }
}




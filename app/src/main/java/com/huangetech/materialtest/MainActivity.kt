package com.huangetech.materialtest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.toolbar,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
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
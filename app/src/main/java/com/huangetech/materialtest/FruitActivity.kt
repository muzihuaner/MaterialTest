package com.huangetech.materialtest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_fruit.*
import kotlinx.android.synthetic.main.activity_main.*

class FruitActivity : AppCompatActivity() {
    companion object{
        const val FRUIT_NAME="fruit_name"
        const val FRUIT_IMAGE_ID="fruit_image_id"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fruit)
        val fruit_Name=intent.getStringExtra(FRUIT_NAME) ?:""
        val fruit_ImageId=intent.getIntExtra(FRUIT_IMAGE_ID,0)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        collapsingToolBar.title=fruit_Name
        Glide.with(this).load(fruit_ImageId).into(fruitImageView)
        fruitContentText.text=generateFruitContent(fruit_Name)


    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            android.R.id.home->{
                finish()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun generateFruitContent(fruitName: String)=fruitName.repeat(500)
}
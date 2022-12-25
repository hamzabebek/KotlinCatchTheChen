package com.example.kotlincatchthechen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class episodes : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_episodes)
    }
    fun levelone(view: View){
        val leveloneIntent = Intent(applicationContext,MainActivity::class.java)
        startActivity(leveloneIntent)
    }
    fun leveltwo(view: View){
        val leveltwoIntent = Intent(applicationContext,leveltwo::class.java)
        startActivity(leveltwoIntent)
    }
    fun levelthree(view: View){
        val levelthreeIntent = Intent(applicationContext,levelthree::class.java)
        startActivity(levelthreeIntent)
    }
}
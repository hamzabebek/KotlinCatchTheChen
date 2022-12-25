package com.example.kotlincatchthechen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class welcomescreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcomescreen)
    }

    fun start(view : View){
        val firstIntent = Intent(applicationContext,MainActivity::class.java)
        startActivity(firstIntent)
    }
    fun episodes(view: View){
        val secondIntent = Intent(applicationContext,episodes::class.java)
        startActivity(secondIntent)
    }
    fun highscorelist(view: View){
        val thirdIntent = Intent(applicationContext,HighScoreList::class.java)
        startActivity(thirdIntent)
    }
}
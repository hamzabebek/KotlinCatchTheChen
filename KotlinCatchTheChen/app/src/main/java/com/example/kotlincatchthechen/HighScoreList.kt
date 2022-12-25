package com.example.kotlincatchthechen

import android.app.Activity
import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.preference.Preference
import androidx.preference.PreferenceManager
import com.example.kotlincatchthechen.databinding.ActivityHighScoreListBinding
import com.example.kotlincatchthechen.databinding.ActivityMainBinding

class HighScoreList : AppCompatActivity() {
    private lateinit var binding: ActivityHighScoreListBinding
    lateinit var sp : SharedPreferences
    var highscore1 = 0
    var highscore2 = 0
    var highscore3 = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHighScoreListBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        sp = PreferenceManager.getDefaultSharedPreferences(applicationContext)
        highscore1 = sp.getInt("highscore1",0)
        highscore2 = sp.getInt("highscore2",0)
        highscore3 = sp.getInt("highscore3",0)
        binding.highscore1.text = "Level 1 Highscore $highscore1"
        binding.highscore2.text = "Level 2 Highscore $highscore2"
        binding.highscore3.text = "Level 3 Highscore $highscore3"
    }
    fun delete1(view: View){
        sp.edit().remove("highscore1").apply()
        binding.highscore1.text = "Level 1 Highscore"
    }
    fun delete2(view : View){
        sp.edit().remove("highscore2").apply()
        binding.highscore2.text = "Level 2 Highscore"
    }
    fun delete3(view : View){
        sp.edit().remove("highscore3").apply()
        binding.highscore3.text = "Level 3 Highscore"
    }
}
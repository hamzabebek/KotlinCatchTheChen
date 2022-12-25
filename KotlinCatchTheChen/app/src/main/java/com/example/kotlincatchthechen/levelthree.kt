package com.example.kotlincatchthechen

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import android.view.View
import android.widget.ImageView
import androidx.appcompat.app.AlertDialog
import androidx.preference.PreferenceManager
import com.example.kotlincatchthechen.databinding.ActivityLevelthreeBinding
import com.example.kotlincatchthechen.databinding.ActivityMainBinding
import java.util.*
import kotlin.collections.ArrayList

class levelthree : AppCompatActivity() {
    var score = 0
    var imageArray = ArrayList<ImageView>()
    var runnable = Runnable {  }
    var handler = Handler()
    lateinit var sp : SharedPreferences
    var highscore3 = 0
    private lateinit var binding: ActivityLevelthreeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLevelthreeBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        //ImageArray

        imageArray.add(binding.imageView)
        imageArray.add(binding.imageView2)
        imageArray.add(binding.imageView3)
        imageArray.add(binding.imageView4)
        imageArray.add(binding.imageView5)
        imageArray.add(binding.imageView6)
        imageArray.add(binding.imageView7)
        imageArray.add(binding.imageView8)
        imageArray.add(binding.imageView9)
        imageArray.add(binding.imageView10)
        imageArray.add(binding.imageView11)
        imageArray.add(binding.imageView12)
        imageArray.add(binding.imageView13)
        imageArray.add(binding.imageView14)
        imageArray.add(binding.imageView15)
        imageArray.add(binding.imageView16)
        imageArray.add(binding.imageView17)
        imageArray.add(binding.imageView18)
        imageArray.add(binding.imageView19)
        imageArray.add(binding.imageView20)

        hideImages()
        //HighScore

        sp = PreferenceManager.getDefaultSharedPreferences(applicationContext)
        highscore3 = sp.getInt("highscore3",0)

        //CountDownTimer

        object : CountDownTimer(15500,1000){
            override fun onTick(p0: Long) {
                binding.timeText.text = "Time : " + p0/1000
            }

            override fun onFinish() {
                binding.timeText.text = "Time :  0"

                handler.removeCallbacks(runnable)

                for(image in imageArray){
                    image.visibility = View.INVISIBLE
                }

                val alert = AlertDialog.Builder(this@levelthree)
                alert.setTitle("Time is Up !!")
                alert.setMessage("Game is Over. If you want to get back main menu please click 'Main Menu' or you can play again this level click 'Play Again'")
                alert.setPositiveButton("Play Again"){dialog, which ->
                    val intent = intent
                    finish()
                    startActivity(intent)
                }
                alert.setNegativeButton("Main Menu"){dialog, which ->
                    val mainIntent = Intent(applicationContext,welcomescreen::class.java)
                    startActivity(mainIntent)
                }
                alert.show()
            }

        }.start()
    }

    fun hideImages(){

        runnable = object : Runnable {
            override fun run() {
                for (image in imageArray){
                    image.visibility = View.INVISIBLE
                }
                val random = Random()
                var randomIndex = random.nextInt(19)
                imageArray[randomIndex].visibility = View.VISIBLE

                handler.postDelayed(runnable,400)
            }

        }
        handler.post(runnable)
    }
    fun increaseScore(view: View){
        score = score + 1
        binding.scoreText.text = "Score : $score"
        if(score > highscore3){
            sp.edit().putInt("highscore3",score).apply()
        }else{
            binding.highscoreText.text = "Highscore :   $highscore3"
        }
    }
}
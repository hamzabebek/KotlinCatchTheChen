package com.example.kotlincatchthechen

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import androidx.preference.PreferenceManager
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.core.content.edit
import com.example.kotlincatchthechen.databinding.ActivityMainBinding
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {

    var score = 0
    var imageArray = ArrayList<ImageView>()
    var runnable = Runnable {  }
    var handler = Handler()
    lateinit var sp : SharedPreferences
    var highscore1 = 0
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
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
        //SharedPreferencesforHighscore
        sp = PreferenceManager.getDefaultSharedPreferences(applicationContext)
        highscore1 = sp.getInt("highscore1",0)
        //CountDownTimer
        object : CountDownTimer(20500,1000){
            override fun onTick(p0: Long) {
                binding.timeText.text = "Time : " + p0/1000
            }

            override fun onFinish() {
                binding.timeText.text = "Time :  0"

                handler.removeCallbacks(runnable)

                for(image in imageArray){
                    image.visibility = View.INVISIBLE
                }

                val alert = AlertDialog.Builder(this@MainActivity)
                alert.setTitle("Time is Up !!")
                alert.setMessage("İf you want to get next level please click on ' Next Level' or click on 'Play Again' and play this level again.")
                alert.setPositiveButton("Play Again"){dialog, which ->
                    //Restart
                    val intent = intent
                    finish()
                    startActivity(intent)
                }
                alert.setNegativeButton("Next Level"){dialog, which ->
                    val leveltwoIntent = Intent(applicationContext,leveltwo::class.java)
                    startActivity(leveltwoIntent)
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

                    handler.postDelayed(runnable,600)
                }

            }
        handler.post(runnable)
        }
        fun increaseScore(view: View){
            score = score + 1
            binding.scoreText.text = "Score : $score"
            if(score > highscore1){
                sp.edit().putInt("highscore1",score).apply()
            }else   {
                binding.highscoreText.text = "Highscore : $highscore1"
            }
        }
}
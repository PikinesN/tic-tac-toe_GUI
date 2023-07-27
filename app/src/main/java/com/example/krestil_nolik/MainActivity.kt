package com.example.krestil_nolik

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MotionEvent
import android.widget.Button
import android.widget.TextView
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity() {
    @SuppressLint("ClickableViewAccessibility")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val one_player: Button = findViewById(R.id.one_player)
        val two_player: Button = findViewById(R.id.two_player)
        val textview: TextView = findViewById(R.id.label)

        one_player.setOnTouchListener { v, event ->
            val action = event.action
            when(action){

                MotionEvent.ACTION_DOWN -> {
                    textview.text = "Кнопка нажата"

                    one_player.setBackgroundColor(ContextCompat.getColor(this, R.color.background_Button_Push))
                    one_player.setTextColor(ContextCompat.getColor(this, R.color.background_Button_notPush))


                }
                MotionEvent.ACTION_MOVE -> {
                    textview.text = "Двигается палец на нажатой кнопке"
                }
                MotionEvent.ACTION_UP -> {
                    textview.text = "Кнопка отпущена"
                    one_player.setBackgroundColor(ContextCompat.getColor(this, R.color.background_Button_notPush))
                    one_player.setTextColor(ContextCompat.getColor(this, R.color.background_Button_Push))

                    val intent = Intent(this, Play_ROBOT::class.java)
                    startActivity(intent)

                }
                MotionEvent.ACTION_CANCEL -> {
                    textview.text = "Когда следует остановить нажатие кнопки"
                }
                else ->{

                }
            }
            true
        }

        two_player.setOnTouchListener { g, motionEvent ->
            when(motionEvent.action){

                MotionEvent.ACTION_DOWN -> {
                    textview.text = "Кнопка нажата"

                    two_player.setBackgroundColor(ContextCompat.getColor(this, R.color.background_Button_Push))
                    two_player.setTextColor(ContextCompat.getColor(this, R.color.background_Button_notPush))


                }
                MotionEvent.ACTION_MOVE -> {
                    textview.text = "Двигается палец на нажатой кнопке"
                }
                MotionEvent.ACTION_UP -> {
                    textview.text = "Кнопка отпущена"
                    two_player.setBackgroundColor(ContextCompat.getColor(this, R.color.background_Button_notPush))
                    two_player.setTextColor(ContextCompat.getColor(this, R.color.background_Button_Push))

                    val intent = Intent(this, one_player_Acrivity::class.java)
                    startActivity(intent)

                }
                MotionEvent.ACTION_CANCEL -> {
                    textview.text = "Когда следует остановить нажатие кнопки"
                }
                else ->{

                }
            }
            true
        }



    }
}
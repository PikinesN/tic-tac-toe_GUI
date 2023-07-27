package com.example.krestil_nolik

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View.INVISIBLE
import android.view.View.VISIBLE
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat

class one_player_Acrivity : AppCompatActivity() {



    var X_or_O = ""
    var a = 1








    var Pobeda_X = 0
    var Pobeda_O = 0
    var pobeda = false

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_one_player_acrivity)



        val chet:TextView = findViewById(R.id.schet)
        chet.text = Pobeda_X.toString() + ":" + Pobeda_O.toString()

        val X:Button = findViewById(R.id.X)
        val O:Button = findViewById(R.id.O)
        val smena:Button = findViewById(R.id.smena)


        X.setBackgroundColor(ContextCompat.getColor(this,R.color.black))
        O.setVisibility(INVISIBLE)





        //Первый ряд
        val one_one:Button = findViewById(R.id.one_one)
        var one_one_prov: Boolean = false

        val one_two:Button = findViewById(R.id.one_two)
        var one_two_prov: Boolean = false

        val one_three:Button = findViewById(R.id.one_three)
        var one_three_prov: Boolean = false

        //Второй ряд
        val two_one:Button = findViewById(R.id.two_one)
        var two_one_prov:Boolean = false

        val two_two:Button = findViewById(R.id.two_two)
        var two_two_prov:Boolean = false

        val two_three:Button = findViewById(R.id.two_three)
        var two_three_prov:Boolean = false

        //Третий ряд
        val three_one:Button = findViewById(R.id.three_one)
        var three_one_prov:Boolean = false

        val three_two:Button = findViewById(R.id.three_two)
        var three_two_prov:Boolean = false

        val three_three:Button = findViewById(R.id.three_three)
        var three_three_prov:Boolean = false

        val arguments = intent.extras

        if (arguments != null) {
            Pobeda_X = arguments.getInt("Pobeda_X")
            chet.text = Pobeda_O.toString() + ":" + Pobeda_X.toString()
        }
        if (arguments != null) {
            Pobeda_O = arguments.getInt("Pobeda_O")
            chet.text = Pobeda_O.toString() + ":" + Pobeda_X.toString()

        }
        smena.setOnClickListener {
            zanogo()
        }





        one_one.setOnClickListener {
            one_one_prov = true
            X_OR_O(X,O)
            one_one.setText(X_or_O)

            one_one.isEnabled = false


            priverka_one_one_one_three_the_coad(one_one_prov,two_one_prov,three_one_prov, one_one, two_one, three_one,one_two,two_two,three_two,one_three,two_three,three_three)
            priverka_one_one_one_three_the_coad(one_one_prov,two_two_prov,three_three_prov,one_one,two_two,three_three, two_one,three_one,one_two,three_two,one_three,two_three)
            priverka_one_one_one_three_the_coad(one_one_prov,one_two_prov,one_three_prov,one_one,one_two,one_three,two_one,three_one,two_two,three_two,two_three,three_three)
            pobeda(X,O)

        }
        one_two.setOnClickListener {
            one_two_prov = true
            X_OR_O(X,O)
            one_two.text = X_or_O

            one_two.isEnabled = false

            priverka_one_one_one_three_the_coad(one_one_prov,one_two_prov,one_three_prov,one_one,one_two,one_three,two_one,three_one,two_two,three_two,two_three,three_three)
            priverka_one_one_one_three_the_coad(one_two_prov,two_two_prov,three_two_prov,one_two,two_two,three_two,one_one,two_one,three_one,one_three,two_three,three_three)
            pobeda(X,O)

        }
        one_three.setOnClickListener {
            one_three_prov = true
            X_OR_O(X,O)
            one_three.text = X_or_O

            one_three.isEnabled = false

            priverka_one_one_one_three_the_coad(one_three_prov, two_two_prov,three_one_prov,one_three,two_two,three_one,one_one,two_one,one_two,two_three,three_three,three_two)
            priverka_one_one_one_three_the_coad(one_one_prov,one_two_prov,one_three_prov,one_one,one_two,one_three,two_one,three_one,two_two,three_two,two_three,three_three)
            priverka_one_one_one_three_the_coad(one_three_prov,two_three_prov,three_three_prov,one_three,two_three,three_three,one_one,one_two,two_one,two_two,three_one,three_two)
            pobeda(X,O)

        }

        two_one.setOnClickListener {
            two_one_prov = true
            X_OR_O(X,O)
            two_one.setText(X_or_O)

            two_one.isEnabled = false
            priverka_one_one_one_three_the_coad(one_one_prov,two_one_prov,three_one_prov, one_one, two_one, three_one,one_two,two_two,three_two,one_three,two_three,three_three)
            priverka_one_one_one_three_the_coad(two_one_prov,two_two_prov,two_three_prov,two_one,two_two,two_three,one_one,one_two,one_three,three_one,three_two,three_three)
            pobeda(X,O)

        }

        two_two.setOnClickListener {
            two_two_prov = true
            X_OR_O(X,O)
            two_two.setText(X_or_O)
            two_two.isEnabled = false

            priverka_one_one_one_three_the_coad(one_one_prov,two_two_prov,three_three_prov,one_one,two_two,three_three, two_one,three_one,one_two,three_two,one_three,two_three)
            priverka_one_one_one_three_the_coad(one_three_prov, two_two_prov,three_one_prov,one_three,two_two,three_one,one_one,two_one,one_two,two_three,three_three,three_two)
            priverka_one_one_one_three_the_coad(two_one_prov,two_two_prov,two_three_prov,two_one,two_two,two_three,one_one,one_two,one_three,three_one,three_two,three_three)
            priverka_one_one_one_three_the_coad(one_two_prov,two_two_prov,three_two_prov,one_two,two_two,three_two,one_one,two_one,three_one,one_three,two_three,three_three)
            pobeda(X,O)

        }

        two_three.setOnClickListener {
            two_three_prov = true
            X_OR_O(X,O)
            two_three.setText(X_or_O)

            two_three.isEnabled = false
            priverka_one_one_one_three_the_coad(two_one_prov,two_two_prov,two_three_prov,two_one,two_two,two_three,one_one,one_two,one_three,three_one,three_two,three_three)
            priverka_one_one_one_three_the_coad(one_three_prov,two_three_prov,three_three_prov,one_three,two_three,three_three,one_one,one_two,two_one,two_two,three_one,three_two)
            pobeda(X,O)

        }

        three_one.setOnClickListener {
            three_one_prov = true
            X_OR_O(X,O)
            three_one.setText(X_or_O)

            three_one.isEnabled = false

            priverka_one_one_one_three_the_coad(one_one_prov,two_one_prov,three_one_prov, one_one, two_one, three_one,one_two,two_two,three_two,one_three,two_three,three_three)
            priverka_one_one_one_three_the_coad(one_three_prov, two_two_prov,three_one_prov,one_three,two_two,three_one,one_one,two_one,one_two,two_three,three_three,three_two)
            priverka_one_one_one_three_the_coad(three_one_prov, three_two_prov,three_three_prov,three_one,three_two,three_three,one_one,two_one,one_two,two_two,one_three,two_three)
            pobeda(X,O)

        }
        three_two.setOnClickListener {
            three_two_prov = true
            X_OR_O(X,O)
            three_two.setText(X_or_O)
            three_two.isEnabled = false

            priverka_one_one_one_three_the_coad(one_two_prov,two_two_prov,three_two_prov,one_two,two_two,three_two,one_one,two_one,three_one,one_three,two_three,three_three)
            priverka_one_one_one_three_the_coad(three_one_prov, three_two_prov,three_three_prov,three_one,three_two,three_three,one_one,two_one,one_two,two_two,one_three,two_three)
            pobeda(X,O)

        }
        three_three.setOnClickListener {
            three_three_prov = true
            X_OR_O(X,O)
            three_three.setText(X_or_O)

            three_three.isEnabled = false
            priverka_one_one_one_three_the_coad(one_one_prov,two_two_prov,three_three_prov,one_one,two_two,three_three, two_one,three_one,one_two,three_two,one_three,two_three)
            priverka_one_one_one_three_the_coad(one_three_prov,two_three_prov,three_three_prov,one_three,two_three,three_three,one_one,one_two,two_one,two_two,three_one,three_two)
            priverka_one_one_one_three_the_coad(three_one_prov, three_two_prov,three_three_prov,three_one,three_two,three_three,one_one,two_one,one_two,two_two,one_three,two_three)
            pobeda(X,O)

        }
    }


    fun X_OR_O(O:Button, X:Button) {
        if ((a == 2) || (a == 4) || (a == 6) || (a == 8)) {
            X_or_O = "O"
            O.setBackgroundColor(ContextCompat.getColor(this,R.color.black))
            O.setVisibility(VISIBLE)
            X.setVisibility(INVISIBLE)
            Log.d("Первый раз", "$a")
            a++
            Log.d("Второй раз", "$a")
        }
        else if ((a == 1||a == 3) || (a == 5) || (a == 7) || a == 9) {
            X_or_O = "X"
            X.setBackgroundColor(ContextCompat.getColor(this,R.color.black))
            X.setVisibility(VISIBLE)
            O.setVisibility(INVISIBLE)
            a++
            Log.d("Tag", "$a")
        }
        else if (a == 10) {
            Toast.makeText(this, "Ходы закончились", Toast.LENGTH_SHORT).show()
        }
    }
    @SuppressLint("SetTextI18n")
    fun priverka_one_one_one_three_the_coad(one: Boolean, two: Boolean, three: Boolean, oneButton: Button, twoButton: Button, threeButton: Button,
                                            oneBlock:Button, twoBlock:Button, threeBlock:Button, foBlick:Button, fiveBlock: Button, sixBlock:Button) {
        if (one && two && three) {
            if (oneButton.text == "X" && twoButton.text == "X" && threeButton.text == "X") {

                val pole:TextView = findViewById(R.id.textView)
                pole.text = "Победил X"

                oneButton.setBackgroundColor(ContextCompat.getColor(this,R.color.teal_700))
                twoButton.setBackgroundColor(ContextCompat.getColor(this,R.color.teal_700))
                threeButton.setBackgroundColor(ContextCompat.getColor(this,R.color.teal_700))

                oneBlock.isEnabled = false
                twoBlock.isEnabled = false
                threeBlock.isEnabled = false
                foBlick.isEnabled = false
                fiveBlock.isEnabled = false
                sixBlock.isEnabled = false

                pobeda = true

                Pobeda_X++
                val chet:TextView = findViewById(R.id.schet)
                chet.text = Pobeda_O.toString() + ":" + Pobeda_X.toString()

            } else if (oneButton.text == "O" && twoButton.text == "O" && threeButton.text == "O") {

                val pole:TextView = findViewById(R.id.textView)
                pole.text = "Победил O"


                oneButton.setBackgroundColor(ContextCompat.getColor(this,R.color.teal_700))
                twoButton.setBackgroundColor(ContextCompat.getColor(this,R.color.teal_700))
                threeButton.setBackgroundColor(ContextCompat.getColor(this,R.color.teal_700))

                oneBlock.isEnabled = false
                twoBlock.isEnabled = false
                threeBlock.isEnabled = false
                foBlick.isEnabled = false
                fiveBlock.isEnabled = false
                sixBlock.isEnabled = false

                pobeda = true

                Pobeda_O++

                val chet:TextView = findViewById(R.id.schet)
                chet.text = Pobeda_O.toString() + ":" + Pobeda_X.toString()

            }
        }
    }

    fun pobeda(X: Button,O: Button) {
        if (pobeda) {
            X.setBackgroundColor(ContextCompat.getColor(this,R.color.black))
            O.setBackgroundColor(ContextCompat.getColor(this,R.color.black))
            X.setVisibility(VISIBLE)
            O.setVisibility(VISIBLE)
        }
    }

    fun zanogo () {
        val intent = Intent(this, one_player_Acrivity::class.java)
        intent.putExtra("Pobeda_X", Pobeda_X)
        intent.putExtra("Pobeda_O", Pobeda_O)


        startActivity(intent)
        finish()
    }


    /*
     smena.setOnClickListener {

            one_one.isEnabled = true
            one_two.isEnabled = true
            one_three.isEnabled = true
            two_one.isEnabled = true
            two_two.isEnabled = true
            two_three.isEnabled = true
            three_one.isEnabled = true
            three_two.isEnabled = true
            three_three.isEnabled = true

            a = 1

            one_one_prov = false
            one_two_prov = false
            one_three_prov = false
            two_one_prov = false
            two_two_prov = false
            two_three_prov = false
            three_one_prov = false
            three_two_prov = false
            three_three_prov = false


            one_one.setText("")
            one_two.setText("")
            one_three.setText("")
            two_one.setText("")
            two_two.setText("")
            two_three.setText("")
            three_one.setText("")
            three_two.setText("")
            three_three.setText("")
        }
     */

}

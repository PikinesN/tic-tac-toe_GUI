package com.example.krestil_nolik

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import java.io.IOException

class Play_ROBOT : AppCompatActivity() {



    var Pobeda_X = 0
    var Pobeda_O = 0
    var pobeda = false

    @SuppressLint("SetTextI18n", "MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_play_robot)


        val hod:TextView = findViewById(R.id.Label)
        hod.text = Pobeda_X.toString() + ":" + Pobeda_O.toString()


        val reset:ImageButton = findViewById(R.id.imageButton)
        reset.setOnClickListener{
            zanogo()
        }

        //Первый ряд
        val one_one: Button = findViewById(R.id.one_one)

        val one_two: Button = findViewById(R.id.one_two)

        val one_three: Button = findViewById(R.id.one_three)

        //Второй ряд
        val two_one: Button = findViewById(R.id.two_one)

        val two_two: Button = findViewById(R.id.two_two)

        val two_three: Button = findViewById(R.id.two_three)

        //Третий ряд
        val three_one: Button = findViewById(R.id.three_one)

        val three_two: Button = findViewById(R.id.three_two)

        val three_three: Button = findViewById(R.id.three_three)



        one_one.setOnClickListener {
            one_one.text = "X"
            postav(one_one,one_two,one_three,two_one,two_two,two_three,three_one,three_two,three_three)
            one_one.isEnabled = false
        }
        one_two.setOnClickListener {
            one_two.text = "X"
            postav(one_one,one_two,one_three,two_one,two_two,two_three,three_one,three_two,three_three)
            one_two.isEnabled = false
        }
        one_three.setOnClickListener {
            one_three.text = "X"
            postav(one_one,one_two,one_three,two_one,two_two,two_three,three_one,three_two,three_three)
            one_three.isEnabled = false
        }

        two_one.setOnClickListener {
            two_one.text = "X"
            postav(one_one,one_two,one_three,two_one,two_two,two_three,three_one,three_two,three_three)
            two_one.isEnabled = false
        }

        two_two.setOnClickListener {
            two_two.text = "X"
            postav(one_one,one_two,one_three,two_one,two_two,two_three,three_one,three_two,three_three)
            two_two.isEnabled = false
        }

        two_three.setOnClickListener {
            two_three.text = "X"
            postav(one_one,one_two,one_three,two_one,two_two,two_three,three_one,three_two,three_three)
            two_three.isEnabled = false
        }

        three_one.setOnClickListener {
            three_one.text = "X"
            postav(one_one,one_two,one_three,two_one,two_two,two_three,three_one,three_two,three_three)
            three_one.isEnabled = false
        }
        three_two.setOnClickListener {
            three_two.text = "X"
            three_two.isEnabled = false
            postav(one_one,one_two,one_three,two_one,two_two,two_three,three_one,three_two,three_three)
        }
        three_three.setOnClickListener {
            three_three.text = "X"
            postav(one_one,one_two,one_three,two_one,two_two,two_three,three_one,three_two,three_three)
            three_three.isEnabled = false
        }

        val arguments = intent.extras
        if (arguments != null) {
            Pobeda_X = arguments.getInt("Pobeda_X")
            hod.text = "$Pobeda_X : $Pobeda_O"
        }
        if (arguments != null) {
            Pobeda_O = arguments.getInt("Pobeda_O")
            hod.text = "$Pobeda_X:$Pobeda_O"
        }
    }
    @SuppressLint("SetTextI18n")
    fun postav(oneButton:Button, twoButton:Button, threeButton:Button, foButton:Button,
               fiveButton:Button, sixButton:Button, sevenButton:Button, eathButton:Button, nineButton:Button) {

        val masiv = arrayOf(
            oneButton,
            twoButton,
            threeButton,
            foButton,
            fiveButton,
            sixButton,
            sevenButton,
            eathButton,
            nineButton
        )

        val Elements_Masiv = mutableListOf<Button>()

        var a = 0
        for (i in masiv) {

            a++
            if (i.text == "") {
                Elements_Masiv.add(i)
                Log.d("1.Что осталось $a", "$Elements_Masiv")
            } else if (i.text == "X") {
                Elements_Masiv.remove(i)
                Log.d("2.Что удалилось", "$i")
            }
        }

        Log.d("3. Что имеем", "$Elements_Masiv")

        val proverka = isEmpty(Elements_Masiv)
        if (!proverka) {
            val random = Elements_Masiv.random()
            random.text = "O"
            random.isEnabled = false
            Log.d("4. Рандом", "$random")
            Log.d("5. Рандом текст", "${random.text}, $random")
        }

            if (oneButton.text == "X" && twoButton.text == "X" && threeButton.text == "X") {
                oneButton.setBackgroundColor(ContextCompat.getColor(this, R.color.teal_700))
                twoButton.setBackgroundColor(ContextCompat.getColor(this, R.color.teal_700))
                threeButton.setBackgroundColor(ContextCompat.getColor(this, R.color.teal_700))

                foButton.isEnabled = false
                fiveButton.isEnabled = false
                sixButton.isEnabled = false
                sevenButton.isEnabled = false
                eathButton.isEnabled = false
                nineButton.isEnabled = false

                Pobeda_X++
                Toast.makeText(this, "XXXXXX", Toast.LENGTH_SHORT).show()
            }
            else if (oneButton.text == "O" && twoButton.text == "O" && threeButton.text == "O") {
                oneButton.setBackgroundColor(ContextCompat.getColor(this, R.color.teal_700))
                twoButton.setBackgroundColor(ContextCompat.getColor(this, R.color.teal_700))
                threeButton.setBackgroundColor(ContextCompat.getColor(this, R.color.teal_700))

                foButton.isEnabled = false
                fiveButton.isEnabled = false
                sixButton.isEnabled = false
                sevenButton.isEnabled = false
                eathButton.isEnabled = false
                nineButton.isEnabled = false

                Pobeda_O++
                Toast.makeText(this, "O", Toast.LENGTH_SHORT).show()
            }
            else if (foButton.text == "X" && fiveButton.text == "X" && sixButton.text == "X") {
                foButton.setBackgroundColor(ContextCompat.getColor(this, R.color.teal_700))
                fiveButton.setBackgroundColor(ContextCompat.getColor(this, R.color.teal_700))
                sixButton.setBackgroundColor(ContextCompat.getColor(this, R.color.teal_700))

                oneButton.isEnabled = false
                twoButton.isEnabled = false
                threeButton.isEnabled = false
                sevenButton.isEnabled = false
                eathButton.isEnabled = false
                nineButton.isEnabled = false

                Pobeda_X++
                Toast.makeText(this, "XXXXXX", Toast.LENGTH_SHORT).show()
            }
            else if (foButton.text == "O" && fiveButton.text == "O" && sixButton.text == "O") {
                foButton.setBackgroundColor(ContextCompat.getColor(this, R.color.teal_700))
                fiveButton.setBackgroundColor(ContextCompat.getColor(this, R.color.teal_700))
                sixButton.setBackgroundColor(ContextCompat.getColor(this, R.color.teal_700))

                oneButton.isEnabled = false
                twoButton.isEnabled = false
                threeButton.isEnabled = false
                sevenButton.isEnabled = false
                eathButton.isEnabled = false
                nineButton.isEnabled = false

                Pobeda_O++
                Toast.makeText(this, "O", Toast.LENGTH_SHORT).show()
            }
            else if (sevenButton.text == "X" && eathButton.text == "X" && nineButton.text == "X") {
                sevenButton.setBackgroundColor(ContextCompat.getColor(this, R.color.teal_700))
                eathButton.setBackgroundColor(ContextCompat.getColor(this, R.color.teal_700))
                nineButton.setBackgroundColor(ContextCompat.getColor(this, R.color.teal_700))

                oneButton.isEnabled = false
                twoButton.isEnabled = false
                threeButton.isEnabled = false
                foButton.isEnabled = false
                fiveButton.isEnabled = false
                sixButton.isEnabled = false

                Pobeda_X++
                Toast.makeText(this, "XXXXXX", Toast.LENGTH_SHORT).show()
            }
            else if (sevenButton.text == "O" && eathButton.text == "O" && nineButton.text == "O") {
                sevenButton.setBackgroundColor(ContextCompat.getColor(this, R.color.teal_700))
                eathButton.setBackgroundColor(ContextCompat.getColor(this, R.color.teal_700))
                nineButton.setBackgroundColor(ContextCompat.getColor(this, R.color.teal_700))

                oneButton.isEnabled = false
                twoButton.isEnabled = false
                threeButton.isEnabled = false
                foButton.isEnabled = false
                fiveButton.isEnabled = false
                sixButton.isEnabled = false

                Pobeda_O++
                Toast.makeText(this, "O", Toast.LENGTH_SHORT).show()
            }
            else if (oneButton.text == "X" && fiveButton.text == "X" && nineButton.text == "X") {
                oneButton.setBackgroundColor(ContextCompat.getColor(this, R.color.teal_700))
                fiveButton.setBackgroundColor(ContextCompat.getColor(this, R.color.teal_700))
                nineButton.setBackgroundColor(ContextCompat.getColor(this, R.color.teal_700))

                twoButton.isEnabled = false
                threeButton.isEnabled = false
                foButton.isEnabled = false
                sixButton.isEnabled = false
                sevenButton.isEnabled = false
                eathButton.isEnabled = false

                Pobeda_X++
                Toast.makeText(this, "XXXXXX", Toast.LENGTH_SHORT).show()
            }
            else if (oneButton.text == "O" && fiveButton.text == "O" && nineButton.text == "O") {
                oneButton.setBackgroundColor(ContextCompat.getColor(this, R.color.teal_700))
                fiveButton.setBackgroundColor(ContextCompat.getColor(this, R.color.teal_700))
                nineButton.setBackgroundColor(ContextCompat.getColor(this, R.color.teal_700))

                twoButton.isEnabled = false
                threeButton.isEnabled = false
                foButton.isEnabled = false
                sixButton.isEnabled = false
                sevenButton.isEnabled = false
                eathButton.isEnabled = false

                Pobeda_O++
                Toast.makeText(this, "O", Toast.LENGTH_SHORT).show()
            }
            else if (threeButton.text == "X" && fiveButton.text == "X" && sevenButton.text == "X") {
                threeButton.setBackgroundColor(ContextCompat.getColor(this, R.color.teal_700))
                fiveButton.setBackgroundColor(ContextCompat.getColor(this, R.color.teal_700))
                sevenButton.setBackgroundColor(ContextCompat.getColor(this, R.color.teal_700))

                oneButton.isEnabled = false
                twoButton.isEnabled = false
                foButton.isEnabled = false
                sixButton.isEnabled = false
                eathButton.isEnabled = false
                nineButton.isEnabled = false

                Pobeda_X++
                Toast.makeText(this, "XXXXXX", Toast.LENGTH_SHORT).show()
            }
            else if (threeButton.text == "O" && fiveButton.text == "O" && sevenButton.text == "O") {
                threeButton.setBackgroundColor(ContextCompat.getColor(this, R.color.teal_700))
                fiveButton.setBackgroundColor(ContextCompat.getColor(this, R.color.teal_700))
                sevenButton.setBackgroundColor(ContextCompat.getColor(this, R.color.teal_700))

                oneButton.isEnabled = false
                twoButton.isEnabled = false
                foButton.isEnabled = false
                sixButton.isEnabled = false
                eathButton.isEnabled = false
                nineButton.isEnabled = false

                Pobeda_O++
                Toast.makeText(this, "O", Toast.LENGTH_SHORT).show()
            }
            else if (oneButton.text == "X" && foButton.text == "X" && sevenButton.text == "X") {
                oneButton.setBackgroundColor(ContextCompat.getColor(this, R.color.teal_700))
                foButton.setBackgroundColor(ContextCompat.getColor(this, R.color.teal_700))
                sevenButton.setBackgroundColor(ContextCompat.getColor(this, R.color.teal_700))

                twoButton.isEnabled = false
                threeButton.isEnabled = false
                fiveButton.isEnabled = false
                sixButton.isEnabled = false
                eathButton.isEnabled = false
                nineButton.isEnabled = false

                Pobeda_X++
                Toast.makeText(this, "XXXXXX", Toast.LENGTH_SHORT).show()
            }
            else if (oneButton.text == "O" && foButton.text == "O" && sevenButton.text == "O") {
                oneButton.setBackgroundColor(ContextCompat.getColor(this, R.color.teal_700))
                foButton.setBackgroundColor(ContextCompat.getColor(this, R.color.teal_700))
                sevenButton.setBackgroundColor(ContextCompat.getColor(this, R.color.teal_700))

                twoButton.isEnabled = false
                threeButton.isEnabled = false
                fiveButton.isEnabled = false
                sixButton.isEnabled = false
                eathButton.isEnabled = false
                nineButton.isEnabled = false

                Pobeda_O++
                Toast.makeText(this, "O", Toast.LENGTH_SHORT).show()
            }
            else if (twoButton.text == "X" && fiveButton.text == "X" && eathButton.text == "X") {
                twoButton.setBackgroundColor(ContextCompat.getColor(this, R.color.teal_700))
                fiveButton.setBackgroundColor(ContextCompat.getColor(this, R.color.teal_700))
                eathButton.setBackgroundColor(ContextCompat.getColor(this, R.color.teal_700))

                oneButton.isEnabled = false
                threeButton.isEnabled = false
                foButton.isEnabled = false
                sixButton.isEnabled = false
                sevenButton.isEnabled = false
                nineButton.isEnabled = false

                Pobeda_X++
                Toast.makeText(this, "XXXXXX", Toast.LENGTH_SHORT).show()
            }
            else if (twoButton.text == "O" && fiveButton.text == "O" && eathButton.text == "O") {
                twoButton.setBackgroundColor(ContextCompat.getColor(this, R.color.teal_700))
                fiveButton.setBackgroundColor(ContextCompat.getColor(this, R.color.teal_700))
                eathButton.setBackgroundColor(ContextCompat.getColor(this, R.color.teal_700))

                oneButton.isEnabled = false
                threeButton.isEnabled = false
                foButton.isEnabled = false
                sixButton.isEnabled = false
                sevenButton.isEnabled = false
                nineButton.isEnabled = false

                Pobeda_O++
                Toast.makeText(this, "O", Toast.LENGTH_SHORT).show()
            }
            else if (threeButton.text == "X" && sixButton.text == "X" && nineButton.text == "X") {
                threeButton.setBackgroundColor(ContextCompat.getColor(this, R.color.teal_700))
                sixButton.setBackgroundColor(ContextCompat.getColor(this, R.color.teal_700))
                nineButton.setBackgroundColor(ContextCompat.getColor(this, R.color.teal_700))

                oneButton.isEnabled = false
                twoButton.isEnabled = false
                foButton.isEnabled = false
                fiveButton.isEnabled = false
                sevenButton.isEnabled = false
                eathButton.isEnabled = false

                Pobeda_X++
            }
            else if (threeButton.text == "O" && sixButton.text == "O" && nineButton.text == "O") {
                threeButton.setBackgroundColor(ContextCompat.getColor(this, R.color.teal_700))
                sixButton.setBackgroundColor(ContextCompat.getColor(this, R.color.teal_700))
                nineButton.setBackgroundColor(ContextCompat.getColor(this, R.color.teal_700))

                oneButton.isEnabled = false
                twoButton.isEnabled = false
                foButton.isEnabled = false
                fiveButton.isEnabled = false
                sevenButton.isEnabled = false
                eathButton.isEnabled = false

                Pobeda_O++
                Toast.makeText(this, "O", Toast.LENGTH_SHORT).show()
            }

        val hod:TextView = findViewById(R.id.Label)
        hod.text = Pobeda_X.toString() + ":" + Pobeda_O.toString()
    }
    fun isEmpty(list: List<*>?): Boolean {
        return list == null || list.isEmpty()
    }

    fun zanogo () {
        val intent = Intent(this, Play_ROBOT::class.java)
        intent.putExtra("Pobeda_X", Pobeda_X)
        intent.putExtra("Pobeda_O", Pobeda_O)
        startActivity(intent)
        finish()
    }
}
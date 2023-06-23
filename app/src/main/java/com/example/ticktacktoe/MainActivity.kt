package com.example.ticktacktoe

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.core.content.ContentProviderCompat.requireContext

class MainActivity : AppCompatActivity() {
    val buttons : ArrayList<Button> = ArrayList()
    var player : String = "X"
    var playerScore : Int = 0
    var botScore : Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val restart : Button = findViewById(R.id.button10)
        val score : TextView = findViewById(R.id.textView)

        buttons.add(findViewById(R.id.button))
        buttons.add(findViewById(R.id.button2))
        buttons.add(findViewById(R.id.button3))
        buttons.add(findViewById(R.id.button4))
        buttons.add(findViewById(R.id.button5))
        buttons.add(findViewById(R.id.button6))
        buttons.add(findViewById(R.id.button7))
        buttons.add(findViewById(R.id.button8))
        buttons.add(findViewById(R.id.button9))

        for (b in buttons){
            b.setOnClickListener {
                b.text = player
                if (CheckWin() == "X"){
                    val dialog = AlertDialog.Builder(this)
                        .setTitle("VICTORY!")
                        .setMessage("You win!")
                    dialog.show()
                    playerScore++
                    score.text = "Score: ${ playerScore } Bot: ${ botScore }"
                    for (b in buttons){ b.text = ""}
                }else if (CheckWin() == "O"){
                    val dialog = AlertDialog.Builder(this)
                        .setTitle("DEFEAT!")
                        .setMessage("You lost!")
                    dialog.show()
                    botScore++
                    score.text = "Score: ${ playerScore } Bot: ${ botScore }"
                    for (b in buttons){ b.text = ""}
                }else{
                    if (player == "X"){ player = "O" }
                    else{ player = "X" }
                }
            }
        }
        restart.setOnClickListener {
            for (b in buttons){ b.text = ""}
        }
    }

    fun CheckWin() : String {
        if (buttons[0].text != "" && buttons[0].text == buttons[1].text && buttons[1].text == buttons[2].text){
            return buttons[0].text.toString()
        }
        if (buttons[3].text != "" && buttons[3].text == buttons[4].text && buttons[4].text == buttons[5].text){
            return buttons[3].text.toString()
        }
        if (buttons[6].text != "" && buttons[6].text == buttons[7].text && buttons[7].text == buttons[8].text){
            return buttons[6].text.toString()
        }
        if (buttons[0].text != "" && buttons[0].text == buttons[3].text && buttons[3].text == buttons[6].text){
            return buttons[0].text.toString()
        }
        if (buttons[1].text != "" && buttons[1].text == buttons[4].text && buttons[4].text == buttons[7].text){
            return buttons[1].text.toString()
        }
        if (buttons[2].text != "" && buttons[2].text == buttons[5].text && buttons[5].text == buttons[8].text){
            return buttons[2].text.toString()
        }
        if (buttons[0].text != "" && buttons[0].text == buttons[4].text && buttons[4].text == buttons[8].text){
            return buttons[0].text.toString()
        }
        if (buttons[2].text != "" && buttons[2].text == buttons[4].text && buttons[4].text == buttons[6].text){
            return buttons[2].text.toString()
        }
        return ""
    }
}
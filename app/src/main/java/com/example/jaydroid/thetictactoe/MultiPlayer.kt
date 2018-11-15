package com.example.jaydroid.thetictactoe

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import java.util.ArrayList

class MultiPlayer : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_multi_player)
    }
    fun mpClick(view: View){
        val mpSelected = view as Button
        var cellID = 0
        when(mpSelected.id){
            R.id.mpb1 -> cellID = 1
            R.id.mpb2 -> cellID = 2
            R.id.mpb3 -> cellID = 3
            R.id.mpb4 -> cellID = 4
            R.id.mpb5 -> cellID = 5
            R.id.mpb6 -> cellID = 6
            R.id.mpb7 -> cellID = 7
            R.id.mpb8 -> cellID = 8
            R.id.mpb9 -> cellID = 9
        }
        //Toast.makeText(this,"Cell ID: "+cellID,Toast.LENGTH_LONG).show()
        playGame(cellID,mpSelected)

    }

    var player1 = ArrayList<Int>()
    var player2 = ArrayList<Int>()

    var activePlayer = 1

    private fun playGame(cellID: Int, mpSelected: Button) {

        if(activePlayer == 1){
            mpSelected.text = "X"
            mpSelected.textSize = 60F
            mpSelected.setBackgroundColor(Color.parseColor("#FFD3DF28"))
            player1.add(cellID)
            activePlayer = 2
        }else{
            mpSelected.text = "O"
            mpSelected.textSize = 60F
            mpSelected.setBackgroundColor(Color.parseColor("#FF42E76E"))
            player2.add(cellID)
            activePlayer = 1
        }
        mpSelected.isEnabled = false

        checkWinner()

    }

    private fun checkWinner() {
        var winner = -1
        //row 1
        if (player1.contains(1) && player1.contains(2) && player1.contains(3)){
            winner = 1
        }
        if (player2.contains(1) && player2.contains(2) && player2.contains(3)){
            winner = 2
        }
        //row 2
        if (player1.contains(4) && player1.contains(5) && player1.contains(6)){
            winner = 1
        }
        if (player2.contains(4) && player2.contains(5) && player2.contains(6)){
            winner = 2
        }
        //row 3
        if (player1.contains(7) && player1.contains(8) && player1.contains(9)){
            winner = 1
        }
        if (player2.contains(7) && player2.contains(8) && player2.contains(9)){
            winner = 2
        }

        //col 1
        if (player1.contains(1) && player1.contains(4) && player1.contains(7)){
            winner = 1
        }
        if (player2.contains(1) && player2.contains(4) && player2.contains(7)){
            winner = 2
        }
        //col 2
        if (player1.contains(2) && player1.contains(5) && player1.contains(8)){
            winner = 1
        }
        if (player2.contains(2) && player2.contains(5) && player2.contains(8)){
            winner = 2
        }
        //col 3
        if (player1.contains(3) && player1.contains(6) && player1.contains(9)){
            winner = 1
        }
        if (player2.contains(3) && player2.contains(6) && player2.contains(9)){
            winner = 2
        }

        if(winner != -1){
            if(winner == 1){
                Toast.makeText(this, "Player 1 won the game.", Toast.LENGTH_LONG).show()
            }else{
                Toast.makeText(this,"Player 2 won the game.", Toast.LENGTH_LONG).show()
            }
        }
    }

}

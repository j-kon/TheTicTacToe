package com.example.jaydroid.thetictactoe

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_single_player.*
import java.util.*

class SinglePlayer : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_single_player)
    }
    fun spClick(view: View){
        val spSelected = view as Button
        var cellID = 0
        when(spSelected.id){
            R.id.spb1 -> cellID = 1
            R.id.spb2 -> cellID = 2
            R.id.spb3 -> cellID = 3
            R.id.spb4 -> cellID = 4
            R.id.spb5 -> cellID = 5
            R.id.spb6 -> cellID = 6
            R.id.spb7 -> cellID = 7
            R.id.spb8 -> cellID = 8
            R.id.spb9 -> cellID = 9
        }
        //Toast.makeText(this,"Cell ID: "+cellID,Toast.LENGTH_LONG).show()
        playGame(cellID,spSelected)
    }

    var player = ArrayList<Int>()
    var computer = ArrayList<Int>()

    var activePlayer = 1

    private fun playGame(cellID: Int, spSelected: Button) {

        if(activePlayer == 1){
            spSelected.text = "X"
            spSelected.textSize = 60F
            spSelected.setBackgroundColor(Color.parseColor("#FFD3DF28"))
            player.add(cellID)
            activePlayer = 2
            AutoPlay()
        }else{
            spSelected.text = "O"
            spSelected.textSize = 60F
            spSelected.setBackgroundColor(Color.parseColor("#FF42E76E"))
            computer.add(cellID)
            activePlayer = 1
        }
        spSelected.isEnabled = false

        checkWinner()

    }

    private fun checkWinner() {
        var winner = -1
        //row 1
        if (player.contains(1) && player.contains(2) && player.contains(3)){
            winner = 1
        }
        if (computer.contains(1) && computer.contains(2) && computer.contains(3)){
            winner = 2
        }
        //row 2
        if (player.contains(4) && player.contains(5) && player.contains(6)){
            winner = 1
        }
        if (computer.contains(4) && computer.contains(5) && computer.contains(6)){
            winner = 2
        }
        //row 3
        if (player.contains(7) && player.contains(8) && player.contains(9)){
            winner = 1
        }
        if (computer.contains(7) && computer.contains(8) && computer.contains(9)){
            winner = 2
        }

        //col 1
        if (player.contains(1) && player.contains(4) && player.contains(7)){
            winner = 1
        }
        if (computer.contains(1) && computer.contains(4) && computer.contains(7)){
            winner = 2
        }
        //col 2
        if (player.contains(2) && player.contains(5) && player.contains(8)){
            winner = 1
        }
        if (computer.contains(2) && computer.contains(5) && computer.contains(8)){
            winner = 2
        }
        //col 3
        if (player.contains(3) && player.contains(6) && player.contains(9)){
            winner = 1
        }
        if (computer.contains(3) && computer.contains(6) && computer.contains(9)){
            winner = 2
        }

        if(winner != -1){
            if(winner == 1){
                Toast.makeText(this, "Player 1 won the game.", Toast.LENGTH_LONG).show()
            }else{
                Toast.makeText(this,"Computer won the game.", Toast.LENGTH_LONG).show()
            }
        }
    }

    private fun AutoPlay(){
        var emptyCells = ArrayList<Int>()
        for(cellID in 1..9){
            if (!(player.contains(cellID) || computer.contains(cellID))){
                emptyCells.add(cellID)
            }
        }
        var r = Random()
        var randIndex = r.nextInt(emptyCells.size-0)+0
        val cellID = emptyCells[randIndex]

        val buSelected:Button
        when(cellID){
            1->buSelected = spb1
            2->buSelected = spb2
            3->buSelected = spb3
            4->buSelected = spb4
            5->buSelected = spb5
            6->buSelected = spb6
            7->buSelected = spb7
            8->buSelected = spb8
            9->buSelected = spb9
            else -> buSelected = spb1
        }
        playGame(cellID,buSelected)
    }
}

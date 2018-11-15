package com.example.jaydroid.thetictactoe

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        spb.setOnClickListener {
            val intent = Intent(this, SinglePlayer::class.java)
            startActivity(intent)
        }
        mpb.setOnClickListener {
            val intent = Intent(this, MultiPlayer::class.java)
            startActivity(intent)
        }
    }
}

package com.example.aleph.trialsubmisiontwo

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_front.*

class FrontActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_front)

        lastMatchButton.setOnClickListener {
            val intent = Intent(this, MatchActivity::class.java)
            // To pass any data to next activity
            intent.putExtra("typeOfMatch", "last match")
            // start your next activity
            startActivity(intent)
        }

        nextMatchButton.setOnClickListener {
            val intent = Intent(this, MatchActivity::class.java)
            // To pass any data to next activity
            intent.putExtra("typeOfMatch", "next match")
            // start your next activity
            startActivity(intent)
        }

    }
}

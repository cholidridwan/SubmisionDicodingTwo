package com.example.aleph.trialsubmisiontwo

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        var  homeId = getIntent().getStringExtra("homeId");
        var  awayId = getIntent().getStringExtra("awayId");

        var  homeName = getIntent().getStringExtra("homeName");
        var  awayName = getIntent().getStringExtra("awayName");

        var  homeScore = getIntent().getStringExtra("homeScore");
        var  awayScore = getIntent().getStringExtra("awayScore");

        var  homeKeeper = getIntent().getStringExtra("homeKeeper");
        var  awayKeeper = getIntent().getStringExtra("awayKeeper");


        homeNameTxt.setText(homeName)
        awayNameTxt.setText(awayName)

        homeScoreTxt.setText(homeScore)
        awayScoreTxt.setText(awayScore)

        homeKeeperTxt.setText(homeKeeper)
        awayKeeperTxt.setText(awayKeeper)


    }
}

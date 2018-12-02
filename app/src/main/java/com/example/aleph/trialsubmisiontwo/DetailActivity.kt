package com.example.aleph.trialsubmisiontwo

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        var  typeOfMatch = getIntent().getStringExtra("typeOfMatch");
        Toast.makeText(this, typeOfMatch, Toast.LENGTH_LONG).show()
    }
}

package com.example.aleph.trialsubmisiontwo

import android.annotation.SuppressLint
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.*
import com.google.gson.Gson
import org.jetbrains.anko.*
import org.jetbrains.anko.recyclerview.v7.recyclerView
import org.jetbrains.anko.support.v4.onRefresh
import org.jetbrains.anko.support.v4.swipeRefreshLayout

class MatchActivity : AppCompatActivity(), MatchView {

    private lateinit var listMatch: RecyclerView
    private lateinit var progressBar: ProgressBar
    private lateinit var swipeRefresh: SwipeRefreshLayout
    //private lateinit var spinner: Spinner
    private var matchs: MutableList<Team> = mutableListOf()
    private lateinit var presenter: MatchPresenter
    private lateinit var adapter: MatchAdapter
    private lateinit var leagueName: String


    @SuppressLint("ResourceType")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)

        var  typeOfMatch = getIntent().getStringExtra("typeOfMatch");
        if (typeOfMatch != "") {
            //throw new IllegalStateException("field " + INTENT_USER_ID + " missing in Intent");
            Toast.makeText(this, typeOfMatch, Toast.LENGTH_LONG).show()
        }

        linearLayout {
            lparams (width = matchParent, height = wrapContent)
            orientation = LinearLayout.VERTICAL
            topPadding = dip(16)
            leftPadding = dip(16)
            rightPadding = dip(16)

            //spinner = spinner ()

            swipeRefresh = swipeRefreshLayout {
                setColorSchemeResources(
                    android.R.color.holo_green_light,
                    android.R.color.holo_green_light,
                    android.R.color.holo_orange_light,
                    android.R.color.holo_red_light)

                relativeLayout{
                    lparams (width = matchParent, height = wrapContent)

                    listMatch = recyclerView {
                        lparams (width = matchParent, height = wrapContent)
                        layoutManager = LinearLayoutManager(ctx)
                    }

                    progressBar = progressBar {
                    }.lparams{
                        centerHorizontally()
                    }
                }
            }
        }

//        val spinnerItems = resources.getStringArray(league)
//        val spinnerAdapter = ArrayAdapter(ctx, android.R.layout.simple_spinner_dropdown_item, spinnerItems)
//        spinner.adapter = spinnerAdapter

        adapter = MatchAdapter(matchs)
        listMatch.adapter = adapter

        val request = ApiRepository()
        val gson = Gson()
        presenter = MatchPresenter(this, request, gson)
        leagueName = "English Premier League"
        presenter.getMatchList(leagueName)

//        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
//            override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {
//                leagueName = spinner.selectedItem.toString()
//                presenter.getMatchList(leagueName)
//            }
//
//            override fun onNothingSelected(parent: AdapterView<*>) {}
//        }

        swipeRefresh.onRefresh {
            presenter.getMatchList(leagueName)
        }


    }

    override fun showLoading() {
        progressBar.visible()
    }

    override fun hideLoading() {
        progressBar.invisible()
    }

    override fun showMatchList(data: List<Team>) {
        swipeRefresh.isRefreshing = false
        matchs.clear()
        matchs.addAll(data)
        adapter.notifyDataSetChanged()
    }

}

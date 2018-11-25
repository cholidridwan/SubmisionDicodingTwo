package com.example.aleph.trialsubmisiontwo

import com.google.gson.Gson
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

class MatchPresenter(private val view: MatchView,
                     private val apiRepository: ApiRepository,
                     private val gson: Gson) {

    //fun getTeamList(league: String?) {
    fun getMatchList(league: String?) {
        view.showLoading()
        doAsync {
            val data = gson.fromJson(apiRepository
                .doRequest(TheSportDBApi.getMatchs(league)),
                TeamResponse::class.java
            )

            uiThread {
                view.hideLoading()
                view.showMatchList(data.teams)
            }
        }
    }
}

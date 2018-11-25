package com.example.aleph.trialsubmisiontwo

interface MatchView {
    fun showLoading()
    fun hideLoading()
    fun showMatchList(data: List<Team>)
}
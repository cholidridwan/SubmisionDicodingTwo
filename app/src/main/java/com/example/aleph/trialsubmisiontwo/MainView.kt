package com.example.aleph.trialsubmisiontwo

interface MainView {
    fun showLoading()
    fun hideLoading()
    fun showTeamList(data: List<Team>)
}
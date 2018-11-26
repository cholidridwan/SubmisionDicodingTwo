package com.example.aleph.trialsubmisiontwo

import com.google.gson.annotations.SerializedName

data class Team(

//    @SerializedName("idTeam")
//    var teamId: String? = null,
//
//    @SerializedName("strTeam")
//    var teamName: String? = null,
//
//    @SerializedName("strTeamBadge")
//    var teamBadge: String? = null

    @SerializedName("idEvent")
    var teamId: String? = null,

    @SerializedName("strEvent")
    var teamName: String? = null,

    @SerializedName("strHomeTeam")
    var strHomeTeam: String? = null,

    @SerializedName("strAwayTeam")
    var strAwayTeam: String? = null,

    @SerializedName("intHomeScore")
    var intHomeScore: String? = null,

    @SerializedName("intAwayScore")
    var intAwayScore: String? = null

)



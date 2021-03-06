package com.example.aleph.trialsubmisiontwo

import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.squareup.picasso.Picasso
import org.jetbrains.anko.*
import com.example.aleph.trialsubmisiontwo.R.id.team_badge
import com.example.aleph.trialsubmisiontwo.R.id.team_name

//class MatchAdapter(private val events: List<Team>): RecyclerView.Adapter<TeamViewHolder>() {
class MatchAdapter(private val context: Context, private val events: List<Team>,
                          private val listener: (Team) -> Unit)
    : RecyclerView.Adapter<TeamViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TeamViewHolder {
        return TeamViewHolder(TeamUI().createView(AnkoContext.create(parent.context, parent)))
    }

    override fun onBindViewHolder(holder: TeamViewHolder, position: Int) {
        //holder.bindItem(events[position])
        holder.bindItem(events[position], listener, context)
//        holder.itemView.setOnClickListener(){
//            val intent = Intent(context, DetailActivity::class.java)
//            // To pass any data to next activity
//            intent.putExtra("typeOfMatch", '')
//            // start your next activity
//            this.context.startActivity(intent)
//        }
    }

    override fun getItemCount(): Int = events.size

}

class TeamUI : AnkoComponent<ViewGroup> {
    override fun createView(ui: AnkoContext<ViewGroup>): View {
        return with(ui) {
            linearLayout {
                lparams(width = matchParent, height = wrapContent)
                padding = dip(16)
                orientation = LinearLayout.HORIZONTAL

                imageView {
                    id = team_badge
                }.lparams{
                    height = dip(50)
                    width = dip(50)
                }

                textView {
                    id = team_name
                    textSize = 16f
                }.lparams{
                    margin = dip(15)
                }

            }
        }
    }

}

class TeamViewHolder(view: View) : RecyclerView.ViewHolder(view){

    private val teamBadge: ImageView = view.find(team_badge)
    private val teamName: TextView = view.find(team_name)

    /*fun bindItem(events: Team) {
        //Picasso.get().load(teams.teamBadge).into(teamBadge)
        teamName.text = events.teamName

        teamName.setOnClickListener {
            //listener(items)
            Log.d("#########::", events.intAwayScore)
        }
    }*/

    fun bindItem(events: Team,  listener: (Team) -> Unit, context: Context) {
        //Picasso.get().load(teams.teamBadge).into(teamBadge)
        teamName.text = events.teamName

        teamName.setOnClickListener {
            //listener(items)
            Log.d("#########::", events.intAwayScore)
            listener(events)

            val intent = Intent(context, DetailActivity::class.java)
            // To pass any data to next activity

            intent.putExtra("homeId", events.idHomeTeam)
            intent.putExtra("awayId", events.idAwayTeam)

            intent.putExtra("homeName", events.strHomeTeam)
            intent.putExtra("awayName", events.strAwayTeam)

            intent.putExtra("homeScore", events.intHomeScore)
            intent.putExtra("awayScore", events.intAwayScore)

            intent.putExtra("homeKeeper", events.strHomeLineupGoalkeeper)
            intent.putExtra("awayKeeper", events.strAwayLineupGoalkeeper)
            // start your next activity
            context.startActivity(intent)
        }
    }
//
//    fun bindItem(items: Item, listener: (Item) -> Unit) {
//        name.text = items.name
//        items.image?.let { Picasso.get().load(it).into(image) }
//        itemView.setOnClickListener {
//            listener(items)
//        }
//    }

}
package com.example.animeworld

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.anime_view.view.*

class AnimeAdapter(
    var items: ArrayList<Animes>,
    var clickListner: OnAnimeItemClickListener)
    : RecyclerView.Adapter<AnimeViewHolder>() {
    override fun getItemCount(): Int {
       return items.size
    }

    override fun onBindViewHolder(holder: AnimeViewHolder, position: Int) {
        holder.initialize(items.get(position),clickListner)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimeViewHolder {
        lateinit var animeViewHolder : AnimeViewHolder
        animeViewHolder = AnimeViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.anime_view,parent,false)
        )
        return animeViewHolder
    }
}

class AnimeViewHolder (itemView: View) :RecyclerView.ViewHolder(itemView){
    var name = itemView.name
    var about = itemView.about
    var image = itemView.image


    fun initialize(item: Animes, action:OnAnimeItemClickListener){
        name.text = item.name
        about.text = item.about
        image.setImageResource(item.image)


        itemView.setOnClickListener{
            action.onItemClick(item, adapterPosition)
        }
    }
}

interface OnAnimeItemClickListener {
    fun onItemClick(item: Animes, position: Int)
}


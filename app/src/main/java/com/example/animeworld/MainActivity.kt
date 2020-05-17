package com.example.animeworld

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.animeworld.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(),OnAnimeItemClickListener {
    lateinit var animelist : ArrayList<Animes>
    lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       binding =  DataBindingUtil.setContentView(this,R.layout.activity_main)
        animelist = ArrayList()
        addAnimes()


        AnimeRecycler.layoutManager = LinearLayoutManager(this)
        AnimeRecycler.addItemDecoration(DividerItemDecoration(this,1))
        AnimeRecycler.adapter = AnimeAdapter(animelist,this)
    }
    fun addAnimes() {
        animelist.add(Animes("Naruto","A japanese Anime",image = R.drawable.portfolio4))
        animelist.add(Animes("Bleach","A korean Anime",image = R.drawable.portfolio5))
        animelist.add(Animes("DeathNote","A chinese Anime",image = R.drawable.portfolio8))
        animelist.add(Animes("Avatar","An American Anime",image = R.drawable.portfolio6))
        animelist.add(Animes("DragonBall","A korean Anime",image = R.drawable.portfolio7))
        animelist.add(Animes("Boruto","A chinese Anime",image = R.drawable.portfolio9))
        animelist.add(Animes("One Piece","A japanese Anime",image = R.drawable.portfolio1))
        animelist.add(Animes("Metal Alchemist","A korean Anime",image = R.drawable.portfolio2))
        animelist.add(Animes("Heroes","A chinese Anime",image = R.drawable.portfolio3))
    }

    override fun onItemClick(item: Animes, position: Int) {
        Toast.makeText(this, item.name , Toast.LENGTH_SHORT).show()
    }

}

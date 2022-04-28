package com.example.tugaschapter6kamis.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.tugaschapter6kamis.R
import com.example.tugaschapter6kamis.model.GetAllFilmItem
import kotlinx.android.synthetic.main.item_film.view.*

class FilmAdapter(private val onClick : (GetAllFilmItem) -> Unit) : RecyclerView.Adapter<FilmAdapter.Viewholder>() {
    private var datafilm : List<GetAllFilmItem>? = null

    fun setDataFilm(film : List<GetAllFilmItem>){
        this.datafilm = film
    }

    class Viewholder(itemView: View):RecyclerView.ViewHolder(itemView){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilmAdapter.Viewholder {
        val itemview = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_film,parent,false)
        return Viewholder(itemview)
    }

    override fun onBindViewHolder(holder: FilmAdapter.Viewholder, position: Int) {
        holder.itemView.tv_film_title.text = datafilm!![position].moviename
        holder.itemView.tv_director.text = datafilm!![position].director
        Glide.with(holder.itemView.context).load(datafilm!![position].image)
            .into(holder.itemView.img_film)
        holder.itemView.cv_film.setOnClickListener {
            onClick(datafilm!![position])
        }
    }

    override fun getItemCount(): Int {
        if(datafilm == null){
            return 0
        }else{
            return datafilm?.size!!
        }
    }
}
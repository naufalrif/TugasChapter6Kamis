package com.example.tugaschapter6kamis.network

import com.example.tugaschapter6kamis.model.GetAllFilmItem
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("movies")
    fun getAllFilm() : Call<List<GetAllFilmItem>>
}
package com.example.tugaschapter6kamis.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.tugaschapter6kamis.model.GetAllFilmItem
import com.example.tugaschapter6kamis.network.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ViewmodelFilm : ViewModel() {
    var liveDataFilm : MutableLiveData<List<GetAllFilmItem>> = MutableLiveData()

    fun getLiveFilm() : MutableLiveData<List<GetAllFilmItem>>{
        return liveDataFilm
    }

    fun getFilmAPI(){
        ApiClient.instance.getAllFilm()
            .enqueue(object : Callback<List<GetAllFilmItem>>{
                override fun onResponse(
                    call: Call<List<GetAllFilmItem>>,
                    response: Response<List<GetAllFilmItem>>
                ) {
                    if (response.isSuccessful){
                        liveDataFilm.postValue(response.body())
                    }else{
                        liveDataFilm.postValue(null)
                    }
                }

                override fun onFailure(call: Call<List<GetAllFilmItem>>, t: Throwable) {
                    liveDataFilm.postValue(null)
                }

            })
    }
}
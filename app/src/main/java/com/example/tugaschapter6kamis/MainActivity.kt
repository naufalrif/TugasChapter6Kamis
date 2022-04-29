package com.example.tugaschapter6kamis

import android.app.ProgressDialog
import android.content.Context
import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tugaschapter6kamis.adapter.FilmAdapter
import com.example.tugaschapter6kamis.viewmodel.ViewmodelFilm
import kotlinx.android.synthetic.main.activity_main.*

@Suppress("DEPRECATION")
class MainActivity : AppCompatActivity() {
    lateinit var cont : Context
    lateinit var adapterfilm : FilmAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        cont = this
        filmAsyncTask().execute()
    }

    inner class filmAsyncTask : AsyncTask<Int,Void,String>(){
        lateinit var pdialog: ProgressDialog

        override fun onPreExecute() {
            super.onPreExecute()
            pdialog = ProgressDialog(cont)
            pdialog.show()
        }

        override fun doInBackground(vararg p0: Int?): String? {
            blankRecyclerView()
            return null
        }

        override fun onProgressUpdate(vararg values: Void?) {
            super.onProgressUpdate(*values)
        }

        override fun onPostExecute(result: String?) {
            super.onPostExecute(result)
            getDataFilm()
            pdialog.dismiss()
        }

        private fun getDataFilm(){
            val viewmodel = ViewModelProvider(this@MainActivity).get(ViewmodelFilm::class.java)
            viewmodel.getLiveFilm().observe(this@MainActivity, Observer {
                if (it != null){
                    adapterfilm.setDataFilm(it)
                    adapterfilm.notifyDataSetChanged()
                }
            })
            viewmodel.getFilmAPI()
        }

        private fun blankRecyclerView(){
            rv_film.layoutManager = LinearLayoutManager(cont)
            adapterfilm = FilmAdapter()
            rv_film.adapter = adapterfilm
        }
    }
}
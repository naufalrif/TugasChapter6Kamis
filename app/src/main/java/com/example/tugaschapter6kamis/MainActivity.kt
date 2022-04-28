package com.example.tugaschapter6kamis

import android.app.ProgressDialog
import android.content.Context
import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
@Suppress("DEPRECATION")
class MainActivity : AppCompatActivity() {
    lateinit var cont : Context
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        cont = this
    }

    inner class filmAsyncTask : AsyncTask<Int,Void,String>(){
        lateinit var pdialog: ProgressDialog

        override fun onPreExecute() {
            super.onPreExecute()
            pdialog = ProgressDialog(cont)
            pdialog.show()
        }

        override fun doInBackground(vararg p0: Int?): String {
            TODO("Not yet implemented")
        }

        override fun onProgressUpdate(vararg values: Void?) {
            super.onProgressUpdate(*values)
        }

        override fun onPostExecute(result: String?) {
            super.onPostExecute(result)
        }
    }
}
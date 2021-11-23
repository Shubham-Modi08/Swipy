package com.shubham.swipy.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.shubham.swipy.model.Response
import com.shubham.swipy.rest.APIService
import com.shubham.swipy.rest.RestClient
import retrofit2.Call
import retrofit2.Callback


class MainViewModel : ViewModel() {

    private val _audioList: MutableLiveData<Response> = MutableLiveData()
    val audioList: LiveData<Response> = Transformations.map(_audioList) { it }

    private var mApiService: APIService? = null


    fun fetchAudioList() {
        mApiService = RestClient.client.create(APIService::class.java)
        val call = mApiService!!.fetchQuestions();
        call.enqueue(object : Callback<Response> {

            override fun onResponse(call: Call<Response>, response: retrofit2.Response<Response>) {
                _audioList.postValue(response.body()!!)
            }

            override fun onFailure(call: Call<Response>, t: Throwable) {
                Log.e("ViewModel", "Got error : " + t.localizedMessage)
            }
        })
    }
}
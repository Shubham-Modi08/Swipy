package com.shubham.swipy.rest

import com.shubham.swipy.model.Audio
import com.shubham.swipy.model.Response
import retrofit2.Call
import retrofit2.http.GET

interface APIService {
    @GET("v3/b9f74279-038b-4590-9f96-7c720261294c")    //End Url
    fun fetchQuestions(): Call<Response>
}

package com.jay.peopleinteractiveassignment.network

import com.jay.peopleinteractiveassignment.model.Results
import com.jay.peopleinteractiveassignment.utility.Constants
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Headers
import java.util.concurrent.TimeUnit

interface ApiInterface {

    @Headers(Constants.APPLICATION_JSON)
    @GET(Constants.GET_PROFILES_URL)
    fun getProfiles(): Call<Results>

    companion object Factory {
        fun create(): ApiInterface {
            val okHttpClient = OkHttpClient.Builder()
                    .writeTimeout(Constants.TIMEOUT, TimeUnit.MINUTES)
                    .readTimeout(Constants.TIMEOUT, TimeUnit.MINUTES)
                    .build()

            val retrofit = Retrofit.Builder()
                    .baseUrl(Constants.BASE_URL)
                    .client(okHttpClient)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            return retrofit.create(ApiInterface::class.java)
        }
    }
}
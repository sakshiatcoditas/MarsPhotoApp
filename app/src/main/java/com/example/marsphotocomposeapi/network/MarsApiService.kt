package com.example.marsphotocomposeapi.network

import com.example.marsphotocomposeapi.model.MarsPhoto

import retrofit2.http.GET


interface MarsApiService {

    @GET("photos")
    suspend fun getPhotos(): List<MarsPhoto>
}

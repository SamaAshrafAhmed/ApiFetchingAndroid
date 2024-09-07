package com.example.apidepi

import retrofit2.http.GET

interface ApiService {
    @GET("albums")
    suspend fun getAlbum():List<Album>
}
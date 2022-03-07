package com.siar.demoapirest.api

import com.siar.demoapirest.model.Album
import com.siar.demoapirest.model.Photo
import retrofit2.Response
import retrofit2.http.GET

interface ApiInterface {

    @GET("albums")
    suspend fun getAllAlbums(): Response<List<Album>>

    @GET("photos")
    suspend fun getAllPhotos(): Response<List<Photo>>
}
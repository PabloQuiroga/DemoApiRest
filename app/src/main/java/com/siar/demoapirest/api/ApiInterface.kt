package com.siar.demoapirest.api

import com.siar.demoapirest.model.Album
import com.siar.demoapirest.model.Photo
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {

    @GET("albums")
    suspend fun getAllAlbums(): List<Album>

    @GET("photos")
    suspend fun getPhotosByAlbumId(@Query("albumId") id: Int): List<Photo>
}
package com.siar.demoapirest.api

import com.siar.demoapirest.model.Album
import com.siar.demoapirest.model.Photo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response

class ApiService {
    private val api: ApiInterface by lazy {
        RetrofitClient.API_INTERFACE
    }
    suspend fun fetchAlbums(): Response<List<Album>> {
        return withContext(Dispatchers.IO) {
            return@withContext api.getAllAlbums()
        }
    }
    suspend fun fetchPhotos(): Response<List<Photo>> {
        return withContext(Dispatchers.IO) {
            return@withContext api.getAllPhotos()
        }
    }
}
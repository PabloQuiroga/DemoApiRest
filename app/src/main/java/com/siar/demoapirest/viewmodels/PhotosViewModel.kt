package com.siar.demoapirest.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.siar.demoapirest.api.ApiService
import com.siar.demoapirest.model.Photo
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class PhotosViewModel: ViewModel(), CoroutineScope {
    override val coroutineContext: CoroutineContext = Job()
    val photosModel = MutableLiveData<List<Photo>>()

    fun fetchData(id: Int) {
        launch {
            val data = ApiService().fetchPhotosByAlbumId(id)
            photosModel.postValue(data)
        }
    }
}
package com.siar.demoapirest.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.siar.demoapirest.api.ApiService
import com.siar.demoapirest.model.Album
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class AlbumsViewModel: ViewModel(), CoroutineScope {

    override val coroutineContext: CoroutineContext = Job()
    val albumModel = MutableLiveData<List<Album>>()

    fun fetchData() {
        launch {
            val data = ApiService().fetchAlbums()
            albumModel.postValue(data)
        }

    }
}
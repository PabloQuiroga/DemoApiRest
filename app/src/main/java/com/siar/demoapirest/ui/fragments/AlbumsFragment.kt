package com.siar.demoapirest.ui.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.siar.demoapirest.databinding.FragmentAlbumsBinding
import com.siar.demoapirest.model.Album
import com.siar.demoapirest.ui.adapters.AlbumAdapter
import com.siar.demoapirest.viewmodels.AlbumsViewModel

class AlbumsFragment : Fragment(), AlbumAdapter.OnAlbumClickListener {

    private lateinit var binding: FragmentAlbumsBinding
    private val albumViewModel: AlbumsViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAlbumsBinding.inflate(inflater, container, false)

        albumViewModel.fetchData()

        binding.recyclerAlbums.layoutManager = LinearLayoutManager(context)
        binding.recyclerAlbums.adapter = AlbumAdapter(emptyList(), this)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        albumViewModel.albumModel.observe(viewLifecycleOwner, Observer {
            it?.let { data -> refreshDataList(data) }
        })
    }

    private fun refreshDataList(data: List<Album>) {
        if(data.isNotEmpty()){
            with(binding.recyclerAlbums.adapter as AlbumAdapter){
                this.itemList = data
                this.notifyDataSetChanged()
            }
        }
    }

    override fun onImageClick() {
        TODO("Not yet implemented")
    }

    override fun onItemClick(id: Int) {
        val direction =  AlbumsFragmentDirections.actionAlbumsToPhotos(id)
        view?.let { Navigation.findNavController(it).navigate(direction) }
    }
}
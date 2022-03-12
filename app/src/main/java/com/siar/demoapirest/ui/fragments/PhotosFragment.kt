package com.siar.demoapirest.ui.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.siar.demoapirest.databinding.FragmentPhotosBinding
import com.siar.demoapirest.model.Photo
import com.siar.demoapirest.ui.adapters.AlbumAdapter
import com.siar.demoapirest.ui.adapters.PhotoAdapter
import com.siar.demoapirest.viewmodels.PhotosViewModel

class PhotosFragment : Fragment() {

    private lateinit var binding: FragmentPhotosBinding
    private val photosViewModel: PhotosViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPhotosBinding.inflate(inflater, container, false)

        arguments?.let {
            photosViewModel.fetchData(PhotosFragmentArgs.fromBundle(it).albumId)
            Log.e("ID LLEGA", PhotosFragmentArgs.fromBundle(it).albumId.toString())
        }

        binding.recyclerPhotos.layoutManager = LinearLayoutManager(context)
        binding.recyclerPhotos.adapter = context?.let { PhotoAdapter(it, emptyList()) }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        photosViewModel.photosModel.observe(viewLifecycleOwner, Observer {
            it?.let {
                data -> refreshList(data)
            }
        })
    }

    private fun refreshList(data: List<Photo>) {
        if (data.isNotEmpty()) {
            with(binding.recyclerPhotos.adapter as PhotoAdapter) {
                this.itemList = data
                this.notifyDataSetChanged()
            }
        }
    }
}
package com.siar.demoapirest.ui.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.siar.demoapirest.databinding.ItemPhotoBinding
import com.siar.demoapirest.model.Photo
import com.squareup.picasso.Picasso

class PhotoAdapter(val context: Context, var itemList: List<Photo>): RecyclerView.Adapter<PhotoAdapter.PhotoViewHolder>(){

    inner class PhotoViewHolder(private val binding: ItemPhotoBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(photo: Photo){
            binding.txtIdAlbum.text = photo.albumId.toString()
            Picasso.get().load(photo.thumbnailUrl).into(binding.imgPhoto)
            binding.txtTitlePhoto.text = photo.title
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoViewHolder =
        PhotoViewHolder(
            ItemPhotoBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: PhotoViewHolder, position: Int) {
        val photo = itemList[position]

        holder.bind(photo)
    }

    override fun getItemCount() = itemList.size


}
package com.siar.demoapirest.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.siar.demoapirest.databinding.ItemAlbumBinding
import com.siar.demoapirest.model.Album

class AlbumAdapter(
    var itemList: List<Album>,
    val albumClickListener: OnAlbumClickListener
) : RecyclerView.Adapter<AlbumAdapter.AlbumViewHolder>() {

    interface OnAlbumClickListener{
        fun onImageClick()
        fun onItemClick(id: Int)
    }

    inner class AlbumViewHolder(private val binding: ItemAlbumBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(album: Album){
            binding.itemAlbum.setOnClickListener {
                albumClickListener.onItemClick(album.id)
            }
            binding.txtidAlbum.text = album.id.toString()
            binding.txttitleAlbum.text = album.title
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): AlbumViewHolder {
        return AlbumViewHolder(ItemAlbumBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        ))
    }

    override fun onBindViewHolder(holder: AlbumViewHolder, position: Int) {
        val album = itemList[position]

        holder.bind(album)
    }

    override fun getItemCount() = itemList.size
}

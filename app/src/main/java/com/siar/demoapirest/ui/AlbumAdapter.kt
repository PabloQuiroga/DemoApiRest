package com.siar.demoapirest.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.siar.demoapirest.databinding.ItemAlbumBinding
import com.siar.demoapirest.model.Album

class AlbumAdapter(
    var itemList: List<Album>
) : RecyclerView.Adapter<AlbumAdapter.AlbumViewHolder>() {

    inner class AlbumViewHolder(binding: ItemAlbumBinding): RecyclerView.ViewHolder(binding.root) {
        val id: TextView = binding.txtidAlbum
        val title: TextView = binding.txttitleAlbum
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): AlbumViewHolder =
        AlbumViewHolder(ItemAlbumBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        ))

    override fun onBindViewHolder(holder: AlbumViewHolder, position: Int) {
        val album = itemList[position]

        holder.id.text = album.id.toString()
        holder.title.text = album.title
    }

    override fun getItemCount() = itemList.size
}

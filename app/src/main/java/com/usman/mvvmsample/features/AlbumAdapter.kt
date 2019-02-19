package com.usman.mvvmsample.features

import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.usman.mvvmsample.R
import com.usman.mvvmsample.databinding.ItemRecyclerBinding
import com.usman.mvvmsample.features.model.Album

/**
 * Created by Muhammad Usman on 2/1/2019.
 */

class AlbumAdapter(private var albums: List<Album>) : RecyclerView.Adapter<AlbumAdapter.AlbumsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlbumsViewHolder {
        val binding: ViewDataBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.item_recycler, parent, false)
        return AlbumsViewHolder(binding)
    }


    override fun getItemCount(): Int {
        return albums.size
    }

    override fun onBindViewHolder(holder: AlbumsViewHolder, p1: Int) {
        holder.bind(albums[holder.adapterPosition])
    }


    class AlbumsViewHolder(val binding: ViewDataBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(album: Album) {
            (binding as ItemRecyclerBinding).album = album
            binding.executePendingBindings()
        }

    }

}
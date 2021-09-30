package com.example.artgallery.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.artgallery.databinding.ArtworkItemBinding
import com.example.artgallery.model.Artwork

class ArtworkGridAdapter : ListAdapter<Artwork, ArtworkGridAdapter.ArtworkViewHolder>(
    DiffCallback
) {

    companion object DiffCallback : DiffUtil.ItemCallback<Artwork>() {

        override fun areItemsTheSame(
            oldItem: Artwork,
            newItem: Artwork
        ): Boolean {
            return oldItem.artworkId == newItem.artworkId
        }

        override fun areContentsTheSame(
            oldItem: Artwork,
            newItem: Artwork
        ): Boolean {
            return oldItem.content.imageSource == newItem.content.imageSource
        }

    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ArtworkViewHolder {
        return ArtworkViewHolder(
            ArtworkItemBinding.inflate(LayoutInflater.from(parent.context))
        )
    }

    override fun onBindViewHolder(holder: ArtworkViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class ArtworkViewHolder(private var binding: ArtworkItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(artwork: Artwork) {
            binding.artwork = artwork
            binding.executePendingBindings()
        }

    }

}
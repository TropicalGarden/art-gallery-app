package com.example.artgallery.adapter

import android.view.View
import android.widget.ImageView
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.artgallery.R
import com.example.artgallery.model.Artwork
import com.example.artgallery.model.ArtworkViewModel.DeviantApiStatus

@BindingAdapter("imageUrl")
fun bindImage(imageView: ImageView, imageUrl: String?) {
    imageUrl?.let {
        val imageUri = imageUrl.toUri().buildUpon().scheme("https").build()
        imageView.load(imageUri) {
            placeholder(R.drawable.loading_animation)
            error(R.drawable.ic_broken_image)
        }
    }
}

@BindingAdapter("listData")
fun bindRecyclerView(recyclerView: RecyclerView, data: List<Artwork>?) {
    val adapter = recyclerView.adapter as ArtworkGridAdapter
    adapter.submitList(data)
}

@BindingAdapter("deviantApiStatus")
fun bindStatus(statusImageView: ImageView, status: DeviantApiStatus?) {
    when (status) {
        DeviantApiStatus.LOADING -> {
            statusImageView.visibility = View.VISIBLE
            statusImageView.setImageResource(R.drawable.loading_animation)
        }
        DeviantApiStatus.ERROR -> {
            statusImageView.visibility = View.VISIBLE
            statusImageView.setImageResource(R.drawable.ic_connection_error)
        }
        DeviantApiStatus.DONE -> {
            statusImageView.visibility = View.GONE
        }
    }
}

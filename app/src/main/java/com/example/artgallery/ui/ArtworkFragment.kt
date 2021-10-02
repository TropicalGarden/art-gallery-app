package com.example.artgallery.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.artgallery.adapter.ArtworkGridAdapter
import com.example.artgallery.databinding.FragmentArtworkBinding
import com.example.artgallery.model.view.ArtworkViewModel

class ArtworkFragment : Fragment() {

    private val viewModel: ArtworkViewModel by viewModels()

    private lateinit var binding: FragmentArtworkBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentArtworkBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            lifecycleOwner = this@ArtworkFragment
            artworkViewModel = this@ArtworkFragment.viewModel
            artworksGrid.adapter = ArtworkGridAdapter()
        }
    }

}
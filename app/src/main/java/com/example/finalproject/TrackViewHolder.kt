package com.example.finalproject

import android.os.Bundle
import androidx.core.os.bundleOf
import androidx.fragment.app.setFragmentResultListener
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.finalproject.databinding.ListItemLayoutBinding


class TrackViewHolder(val binding: ListItemLayoutBinding) : RecyclerView.ViewHolder(binding.root) {

    lateinit var currentTrack: Track
    val rootView = binding.root
    fun bindTracks(track: Track) {
        currentTrack = track
        binding.artistName.text = currentTrack.singer
        binding.songTitle.text = currentTrack.songName
        binding.album.setImageResource(currentTrack.resId)

    }

}



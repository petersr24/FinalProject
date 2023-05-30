package com.example.finalproject

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.finalproject.databinding.ListItemLayoutBinding

class TrackAdapter(val trackList: List<Track>): RecyclerView.Adapter<TrackViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TrackViewHolder {
        val binding= ListItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TrackViewHolder(binding)
    }

    override fun onBindViewHolder(currentViewHolder: TrackViewHolder, position: Int) {
        val currentTrack = trackList[position]
        currentViewHolder.bindTracks(currentTrack)
    }

    override fun getItemCount(): Int {
        return trackList.size
    }
}
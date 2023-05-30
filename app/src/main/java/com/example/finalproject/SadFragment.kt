package com.example.finalproject

import android.os.Bundle
import android.view.*
import android.view.ViewGroup
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.finalproject.databinding.FragmentSadBinding

class SadFragment : Fragment() {
    private var _binding: FragmentSadBinding? = null
    private val binding get() = _binding!!



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSadBinding.inflate(inflater,container,false)
        val rootView = binding.root

        binding.playlistTitle.text = "My Sad Playlist Reccomendation"

        binding.like.setOnClickListener() {
            Toast.makeText(activity, "Yay! Glad you like it!", Toast.LENGTH_SHORT).show()
        }
        binding.dislike.setOnClickListener(){
            Toast.makeText(activity, "Oh no!", Toast.LENGTH_SHORT).show()
        }

        val sadSongs = listOf(
            Track("All too well", "Taylor Swift", false, R.drawable.red),
            Track("Last Kiss", "Taylor Swift", false, R.drawable.speak_now),
            Track("Nothing New", "Taylor Swift", false, R.drawable.red),
            Track("this is me trying", "Taylor Swift", false, R.drawable.folklore),
            Track("The Archer", "Taylor Swift", false, R.drawable.lover),
            Track("Champagne Problems", "Taylor Swift", false, R.drawable.evermore),
            Track("Dear John", "Taylor Swift", false, R.drawable.speak_now),
            Track("The Last Time", "Taylor Swift", false, R.drawable.red),
            Track("You're on Your Own Kid", "Taylor Swift", false, R.drawable.midnights),
            Track("Teardrops on my Guitar", "Taylor Swift", false, R.drawable.debut),
            Track("White Horse", "Taylor Swift", false, R.drawable.fearless),
            Track("The Moment I knew", "Taylor Swift", false, R.drawable.red),
            Track("tolerate it", "Taylor Swift", false, R.drawable.evermore),
            Track("Cardigan", "Taylor Swift", false, R.drawable.folklore),
            Track("tis the damn season", "Taylor Swift", false, R.drawable.evermore),
            Track("Never Grow Up", "Taylor Swift", false, R.drawable.speak_now),
            Track("New Years Day", "Taylor Swift", false, R.drawable.rep),
            Track("illicit affairs", "Taylor Swift", false, R.drawable.folklore),
            Track("my tears ricochet", "Taylor Swift", false, R.drawable.folklore),
            Track("You're Not Sorry", "Taylor Swift", false, R.drawable.fearless),
            Track("right where you left me", "Taylor Swift", false, R.drawable.evermore),
            Track("Sad Beautiful Tragic", "Taylor Swift", false, R.drawable.red),
            Track("Bigger Than The Whole Sky", "Taylor Swift", false, R.drawable.midnights),
            Track("marjorie", "Taylor Swift", false, R.drawable.evermore),
            Track("Back to December", "Taylor Swift", false, R.drawable.speak_now),
        )


        val myAdapter = TrackAdapter(sadSongs)
        binding.sadRecyclerView.adapter = myAdapter

        setHasOptionsMenu(true)
        return rootView

    }
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater){
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.options_menu, menu)
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item, requireView().findNavController()) || super.onOptionsItemSelected(item)
    }


}
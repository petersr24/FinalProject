package com.example.finalproject

import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.finalproject.databinding.FragmentAngryBinding

class AngryFragment : Fragment() {
    private var _binding: FragmentAngryBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAngryBinding.inflate(inflater,container,false)
        val rootView = binding.root

        binding.playlistTitle.text = "My Angry Playlist Reccomendation"

        binding.like.setOnClickListener() {
            Toast.makeText(activity, "Yay! Glad you like it!", Toast.LENGTH_SHORT).show()
        }
        binding.dislike.setOnClickListener(){
            Toast.makeText(activity, "Oh no!", Toast.LENGTH_SHORT).show()
        }


        val angrySongs = listOf(
            Track("Picture to Burn", "Taylor Swift", false, R.drawable.debut),
            Track("The Man", "Taylor Swift", false, R.drawable.lover),
            Track("...Ready For It?", "Taylor Swift", false, R.drawable.rep),
            Track("Karma", "Taylor Swift", false, R.drawable.midnights),
            Track("I Bet You Think About Me", "Taylor Swift", false, R.drawable.red),
            Track("I Forgot That You Existed", "Taylor Swift", false, R.drawable.lover),
            Track("Mean", "Taylor Swift", false, R.drawable.speak_now),
            Track("Mr. Perfectly Fine", "Taylor Swift", false, R.drawable.fearless),
            Track("Better Than Revenge", "Taylor Swift", false, R.drawable.speak_now),
            Track("Look What You Made Me Do", "Taylor Swift", false, R.drawable.rep),
            Track("no body no crime", "Taylor Swift", false, R.drawable.evermore),
            Track("Should've Said No", "Taylor Swift", false, R.drawable.debut),
            Track("Bad Blood", "Taylor Swift", false, R.drawable.nineteen),
            Track("You're Not Sorry", "Taylor Swift", false, R.drawable.fearless),
            Track("I Did Something Bad", "Taylor Swift", false, R.drawable.rep),



        )


        val myAdapter = TrackAdapter(angrySongs)
        binding.angryRecyclerView.adapter = myAdapter

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
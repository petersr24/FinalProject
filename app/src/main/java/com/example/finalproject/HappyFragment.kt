package com.example.finalproject


import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.TextView
import android.widget.Toast
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.finalproject.databinding.ActivityMainBinding.inflate
import com.example.finalproject.databinding.FragmentHappyBinding


class HappyFragment : Fragment() {
    private var _binding: FragmentHappyBinding? = null
    private val binding get() = _binding!!



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHappyBinding.inflate(inflater,container,false)
        val rootView = binding.root








        binding.playlistTitle.text = "My Happy Playlist Reccomendation"

        binding.like.setOnClickListener() {
            Toast.makeText(activity, "Yay! Glad you like it!", Toast.LENGTH_SHORT).show()
        }
        binding.dislike.setOnClickListener(){
            Toast.makeText(activity, "Oh no!", Toast.LENGTH_SHORT).show()
        }

        val happySongs = listOf(
            Track("London Boy", "Taylor Swift", false, R.drawable.lover),
            Track("Paper Rings", "Taylor Swift",false, R.drawable.lover),
            Track("Mine", "Taylor Swift", false, R.drawable.speak_now),
            Track("Call it What You Want", "Taylor Swift", false, R.drawable.rep),
            Track("The Way I Loved You", "Taylor Swift", false, R.drawable.fearless),
            Track("Wonderland", "Taylor Swift", false, R.drawable.nineteen),
            Track("Sparks Fly", "Taylor Swift", false, R.drawable.speak_now),
            Track("Begin Again", "Taylor Swift", false, R.drawable.red),
            Track("Our Song", "Taylor Swift", false, R.drawable.debut),
            Track("Ours", "Taylor Swift", false, R.drawable.speak_now),
            Track("Question...?", "Taylor Swift", false, R.drawable.midnights),
            Track("I Think He Knows", "Taylor Swift", false, R.drawable.lover),
            Track("King Of My Heart", "Taylor Swift", false, R.drawable.rep),
            Track("How You Get The Girl", "Taylor Swift", false, R.drawable.nineteen),
            Track("Hey Stephen", "Taylor Swift", false, R.drawable.fearless),
            Track("Long Live", "Taylor Swift", false, R.drawable.speak_now),
            Track("The Other Side Of The Door", "Taylor Swift", false, R.drawable.fearless),
            Track("Starlight", "Taylor Swift", false, R.drawable.red),
            Track("Mary's Song (Oh My My My)", "Taylor Swift", false, R.drawable.debut),
            Track("Lover", "Taylor Swift", false, R.drawable.lover),
            Track("Come In With The Rain", "Taylor Swift", false, R.drawable.fearless),
            Track("Bejeweled", "Taylor Swift", false, R.drawable.midnights),
        )
        val myAdapter = TrackAdapter(happySongs)
        binding.happyRecyclerView.adapter = myAdapter

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

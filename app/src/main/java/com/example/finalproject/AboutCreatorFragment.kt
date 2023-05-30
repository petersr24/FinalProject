package com.example.finalproject

import android.R
import android.content.Intent
import android.graphics.Color.red
import android.graphics.drawable.AnimationDrawable
import android.net.Uri
import android.os.Bundle
import android.view.*
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.finalproject.databinding.FragmentAboutCreatorBinding


class AboutCreatorFragment : Fragment() {
    private var _binding: FragmentAboutCreatorBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAboutCreatorBinding.inflate(inflater, container, false)
        val rootView = binding.root

        binding.phone.setOnClickListener(){
            dialPhoneNumber()
        }
        binding.gmail.setOnClickListener(){
            composeEmail()
        }

        setHasOptionsMenu(true)
        return rootView
    }
    fun dialPhoneNumber() {
        val intent = Intent(Intent.ACTION_DIAL).apply {
            data = Uri.parse("tel:5706875450" )
        }
        if (activity?.let { intent.resolveActivity(it.packageManager)} != null) {
            startActivity(intent)
        }
    }
    fun composeEmail() {
        val intent = Intent(Intent.ACTION_SENDTO,Uri.fromParts("mailto", "petersr24@hsnet.ahsd.org", null));
            intent.putExtra(Intent.EXTRA_SUBJECT, "Love this app!")

        if (activity?.let { intent.resolveActivity(it.packageManager)} != null) {
            startActivity(intent)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(com.example.finalproject.R.menu.options_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(
            item,
            requireView().findNavController()
        ) || super.onOptionsItemSelected(item)
    }


}
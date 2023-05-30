package com.example.finalproject

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.finalproject.databinding.FragmentAboutBinding


class AboutFragment : Fragment() {

    private var _binding: FragmentAboutBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAboutBinding.inflate(inflater, container, false)
        val rootView = binding.root
        binding.website.setOnClickListener() {
            openWebPage()
        }
        binding.aboutCreator.setOnClickListener() {
            val action = AboutFragmentDirections.actionAboutFragmentToAboutCreatorFragment()
            rootView.findNavController().navigate(action)
        }
        binding.article.setOnClickListener() {
            openArticle()
        }

        setHasOptionsMenu(true)
        return rootView
    }

    fun openWebPage() {
        val browserIntent = Intent(Intent.ACTION_VIEW).apply {
            data = Uri.parse("https://store.taylorswift.com/")
        }
        if (activity?.let { browserIntent.resolveActivity(it.packageManager) } != null) {
            startActivity(browserIntent)
        }

    }

    fun openArticle() {
        val browserIntent = Intent(Intent.ACTION_VIEW).apply{
            data =   Uri.parse("https://today.uconn.edu/2023/02/strategies-for-success-in-business-taylors-version/")
        }
        if (activity?.let { browserIntent.resolveActivity(it.packageManager) } != null) {
            startActivity(browserIntent)
        }    }


    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.options_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(
            item,
            requireView().findNavController()
        ) || super.onOptionsItemSelected(item)
    }

}

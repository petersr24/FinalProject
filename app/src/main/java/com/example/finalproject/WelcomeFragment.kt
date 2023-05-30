package com.example.finalproject

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.core.app.Person.fromBundle
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.finalproject.databinding.FragmentWelcomeBinding


class WelcomeFragment : Fragment() {

    private var _binding: FragmentWelcomeBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentWelcomeBinding.inflate(inflater, container, false)
        val rootView = binding.root
        val args = WelcomeFragmentArgs.fromBundle(requireArguments())
        binding.welcomeTV.text = " ${args.name}"

        binding.sadbutton.setOnClickListener(){
            val action = WelcomeFragmentDirections.actionWelcomeFragmentToSadFragment()
            rootView.findNavController().navigate(action)
        }
        binding.happybutton.setOnClickListener(){
            val action = WelcomeFragmentDirections.actionWelcomeFragmentToHappyFragment()
            rootView.findNavController().navigate(action)
        }
        binding.angrybutton.setOnClickListener(){
            val action = WelcomeFragmentDirections.actionWelcomeFragmentToAngryFragment()
            rootView.findNavController().navigate(action)
        }

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
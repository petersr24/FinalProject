package com.example.finalproject

import android.os.Bundle
import android.view.*
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResult
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.finalproject.databinding.FragmentAboutBinding
import com.example.finalproject.databinding.FragmentFunFactBinding
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class FunFactFragment : Fragment() {
    private var _binding: FragmentFunFactBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFunFactBinding.inflate(inflater, container, false)
        val rootView = binding.root

        binding.blurb.setOnClickListener(){
            MaterialAlertDialogBuilder(requireContext()).setTitle("Be careful choosing your favorite, you can only choose once!")
                   .setMessage("Do you understand?")
                   .setPositiveButton("Yes") { _, _ ->
                   }.setNegativeButton("No"){ _, _ ->
                    rootView.findNavController().navigateUp()
                }.show()
        }

       binding.factOne.setOnClickListener() {  val reply = binding.factOne.text
           setFragmentResult("BACK_TO_LIST_KEY", bundleOf("REPLY_KEY" to reply))
           rootView.findNavController().navigateUp()
       }

        binding.factTwo.setOnClickListener() {  val reply = binding.factTwo.text
            setFragmentResult("BACK_TO_LIST_KEY", bundleOf("REPLY_KEY" to reply))
            rootView.findNavController().navigateUp()
        }

        binding.factThree.setOnClickListener() {
            val reply = binding.factThree.text
            setFragmentResult("BACK_TO_LIST_KEY", bundleOf("REPLY_KEY" to reply))
            rootView.findNavController().navigateUp()
        }

        binding.factFour.setOnClickListener() {  val reply = binding.factFour.text
            setFragmentResult("BACK_TO_LIST_KEY", bundleOf("REPLY_KEY" to reply))
            rootView.findNavController().navigateUp()
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
package com.example.finalproject

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.TextView
import androidx.fragment.app.setFragmentResultListener
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.finalproject.databinding.FragmentChooseRouteBinding
import com.example.finalproject.databinding.FragmentWelcomeBinding


class ChooseRouteFragment : Fragment() {
    private var _binding: FragmentChooseRouteBinding? = null
    private val binding get() = _binding!!

    val listItems: MutableList<String> = mutableListOf()
    var itemCount = 0
    lateinit var listText:List<TextView>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentChooseRouteBinding.inflate(inflater, container, false)
        val rootView = binding.root

        listText = listOf(binding.favorite)

        val args = ChooseRouteFragmentArgs.fromBundle(requireArguments())
        binding.welcomeTV.text = "Welcome ${args.name}"

        binding.playRec.setOnClickListener(){
            val message= binding.welcomeTV.text.toString()
            val action = ChooseRouteFragmentDirections.actionChooseRouteFragmentToWelcomeFragment(message)
            rootView.findNavController().navigate(action)
        }
        binding.fFacts.setOnClickListener(){
            val action = ChooseRouteFragmentDirections.actionChooseRouteFragmentToFunFactFragment()
            rootView.findNavController().navigate(action)
        }

        setFragmentResultListener("BACK_TO_LIST_KEY"){ requestKey: String, bundle: Bundle ->
            val item = bundle.getString("REPLY_KEY")
            if(itemCount<=listText.size-1) {
                listItems.add(item.toString())
                itemCount++

            }
            for((index)in listItems.withIndex()) {
                listText[index].text = listItems[index]
            }
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
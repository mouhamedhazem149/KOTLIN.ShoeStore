package com.udacity.shoestore

import android.os.Bundle
import android.view.*
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import com.udacity.shoestore.databinding.FragmentShoelistBinding
import com.udacity.shoestore.databinding.SampleShoeViewBinding
import com.udacity.shoestore.models.Shoe

class ShoelistFragment : Fragment() {

    private val viewModel : ShoelistViewModel by activityViewModels()

    private lateinit var binding: FragmentShoelistBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_shoelist,
            container,
            false
        )

        if (arguments != null) {
            var args = ShoelistFragmentArgs.fromBundle(arguments!!)
            if (args.addedShoe != null)
                viewModel.AddShoe(args.addedShoe!!)
        }

        binding.addshoeButton.setOnClickListener {
            findNavController().navigate(ShoelistFragmentDirections.actionShoelistFragmentToShoedetailFragment())
        }

        viewModel.shoesList.observe(this.viewLifecycleOwner, Observer {
            for (shoe : Shoe in it)
            {
                val layoutBinding = DataBindingUtil.inflate<SampleShoeViewBinding>(
                    inflater,
                    R.layout.sample_shoe_view,
                    binding.shoelistLinearlayout,
                true)

                layoutBinding.shoeModel = shoe

                //binding.shoelistLinearlayout.addView(layoutBinding.root)
            }
        })

        setHasOptionsMenu(true)

        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.shoelist_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item, requireView().findNavController())
                || super.onOptionsItemSelected(item)
    }
}
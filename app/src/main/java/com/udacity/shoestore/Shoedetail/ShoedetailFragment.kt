package com.udacity.shoestore

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.udacity.shoestore.databinding.FragmentShoedetailBinding
import com.udacity.shoestore.models.Shoe
import kotlinx.android.synthetic.main.fragment_shoedetail.view.*

class ShoedetailFragment : Fragment() {

    private lateinit var binding: FragmentShoedetailBinding
private lateinit var viewModel : ShoedetailViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(inflater,
        R.layout.fragment_shoedetail,
            container,
        false)

        viewModel = ViewModelProvider(this).get(ShoedetailViewModel::class.java)

        binding.shoedetailViewModel = viewModel

        binding.saveButton.setOnClickListener { view ->
//            val _shoe = Shoe(binding.shoenameText.text.toString(),
//                binding.shoesizeText.text.toString().toDoubleOrNull() ?: 0.0,
//                binding.companyText.text.toString(),
//                binding.descriptionText.text.toString())

            val _shoe : Shoe = viewModel.shoe.value!!
            view.findNavController().navigate(ShoedetailFragmentDirections.actionShoedetailFragmentToShoelistFragment(_shoe))
         }

        binding.cancelButton.cancel_button.setOnClickListener { view  ->
            view.findNavController().navigate(ShoedetailFragmentDirections.actionShoedetailFragmentToShoelistFragment())
        }

        binding.setLifecycleOwner(this.viewLifecycleOwner)

        return binding.root
    }
}
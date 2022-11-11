package com.udacity.shoestore

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe

class ShoedetailViewModel : ViewModel() {

    private val _shoe = MutableLiveData<Shoe>()
    val shoe : LiveData<Shoe>
    get() = _shoe

    init {
        _shoe.value = Shoe("",0.0,"","")
    }
}
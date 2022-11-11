package com.udacity.shoestore

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe

class ShoelistViewModel : ViewModel() {

    private val _shoesList = MutableLiveData<ArrayList<Shoe>>()
    val shoesList : LiveData<ArrayList<Shoe>>
    get() = _shoesList

    init {
        /* uncomment to have preloaded list */

        _shoesList.value = arrayListOf(
           /* Shoe("shoe 1",0.0,"company 1","description"),
            Shoe("shoe 2",12.0,"company 8","a looong description"),
            Shoe("shoe 3",15.8,"company 2","longyuan "),
            Shoe("shoe 4",18.0,"company 5","despian comedy"),
            Shoe("shoe 5",20.5,"company 3","mirror jade"),
            Shoe("shoe 5",23.9,"company 4","mirror force")*/)
    }

    fun AddShoe(_shoe : Shoe){

        val tempList : ArrayList<Shoe>  = _shoesList.value?: arrayListOf()

        tempList.add(_shoe)

        _shoesList.value = tempList

    }
}
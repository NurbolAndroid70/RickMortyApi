package com.example.rickmortyapi.ui.second_activity

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.rickmortyapi.repository.Repository
import com.example.rickmortyapi.utils.Resource

class SecondViewModel(private val repository: Repository) : ViewModel() {

    private val _charactersLv = MutableLiveData<Resource<Character>>()
    val charactersLv: LiveData<Resource<Character>> = _charactersLv
    fun getCharacter(id: Int) {
        _charactersLv.value = Resource.Loading()
        repository.getCharacter(id).observeForever { resource ->
            _charactersLv.value = resource
        }
    }
}
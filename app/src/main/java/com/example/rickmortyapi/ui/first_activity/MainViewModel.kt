package com.example.rickmortyapi.ui.first_activity

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.rickmortyapi.model.BaseResponse
import com.example.rickmortyapi.repository.Repository
import com.example.rickmortyapi.utils.Resource

class MainViewModel(
    private val repository: Repository
) : ViewModel() {

    private val _charactersLv = MutableLiveData<Resource<BaseResponse>>()
    val charactersLv: LiveData<Resource<BaseResponse>> = _charactersLv
    fun getCharacters() {
        _charactersLv.value = Resource.Loading()
        repository.getCharacters().observeForever { resource ->
            _charactersLv.value = resource
        }
    }

}
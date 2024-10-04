package com.example.rickmortyapi.repository

import androidx.lifecycle.LiveData
import com.example.rickmortyapi.api.CartoonApiService
import com.example.rickmortyapi.base.BaseRepository
import com.example.rickmortyapi.model.BaseResponse
import com.example.rickmortyapi.utils.Resource

class Repository(private val api: CartoonApiService) : BaseRepository() {
    fun getCharacters(): LiveData<Resource<BaseResponse>> = doRequest {
        api.getCharacters()
    }

    fun getCharacter(id: Int): LiveData<Resource<Character>> = doRequest {
        api.getCharacter(id)
    }

}
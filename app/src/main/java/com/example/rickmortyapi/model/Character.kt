package com.example.rickmortyapi.model
import java.io.Serializable

data class BaseResponse(
    var results: List<Character>
) : java.io.Serializable

data class Character(
    var id: Int,
    var name: String,
    var status: String,
    var gender: String,
    var image: String,
    var species: String,
    var origin: Origin,
    var location: Location
) : java.io.Serializable

data class Origin(
    var name: String
) : java.io.Serializable

data class Location(
    var name: String
) : Serializable
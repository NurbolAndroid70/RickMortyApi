package com.example.rickmortyapi.utils

import android.widget.ImageView
import com.example.rickmortyapi.R

class Status (private val imgCircleStatus: ImageView) {

    fun setStatusImage(status: String) {
        when (status) {
            "Alive" -> imgCircleStatus.setBackgroundResource(R.drawable.ic_alive)
            "Dead" -> imgCircleStatus.setBackgroundResource(R.drawable.ic_death)
            else -> imgCircleStatus.setBackgroundResource(R.drawable.ic_unknown)
        }
    }
}
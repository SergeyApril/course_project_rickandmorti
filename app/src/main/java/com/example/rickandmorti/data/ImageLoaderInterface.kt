package com.example.rickandmorti.data

import android.view.View
import android.widget.ImageView

interface ImageLoaderInterface{
    fun loadImage(itemView : View,ivImageCharacterForRecycler : ImageView, imageCharacter: String){

    }
}
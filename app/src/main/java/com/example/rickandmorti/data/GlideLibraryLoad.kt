package com.example.rickandmorti.data

import android.util.Log
import android.view.View
import android.widget.ImageView
import com.bumptech.glide.Glide

class GlideLibraryLoad : ImageLoaderInterface {
    override fun loadImage(itemView : View, ivImageCharacterForRecycler : ImageView, imageCharacter: String) {
        Glide.with(itemView.context)
            .load(imageCharacter)
            .into(ivImageCharacterForRecycler)
        Log.d("Request", Glide.with(itemView.context).load(imageCharacter).toString())
    }

}
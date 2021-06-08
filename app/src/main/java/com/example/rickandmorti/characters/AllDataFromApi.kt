package com.example.rickandmorti.characters

import com.google.gson.annotations.SerializedName

class AllDataFromApi(
     //   @SerializedName("info")  var info :String,
        @SerializedName("results") var listCharacters : List<Character>
) {
}
package com.example.rickandmorti.characters

import com.google.gson.annotations.SerializedName

data class AllDataFromApi(@SerializedName("info")  var info : Info,  @SerializedName("results") var listCharacters : List<Character>
) {
}
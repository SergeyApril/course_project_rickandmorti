package com.example.rickandmorti.characters

import com.google.gson.annotations.SerializedName

class Character(
        @SerializedName("id")  var idCharacter: Int,
        @SerializedName("name") var nameCharacter: String,
        @SerializedName("status") var statusCharacter: String,
        @SerializedName("species") var speciesCharacter: String,
        @SerializedName("type") var typeCharacter: String,
        @SerializedName("gender") var genderCharacter: String,
        @SerializedName("origin") var originCharacter: Origin,
        @SerializedName("location") var locationCharacter: Location,
        @SerializedName("image") var imageCharacter: String,
        @SerializedName("episode") var episodeCharacter: List<String>,
        @SerializedName("url") var urlCharacter: String,
        @SerializedName("created") var createdCharacter: String) {

}
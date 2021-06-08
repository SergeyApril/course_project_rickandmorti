package com.example.rickandmorti

import android.util.Log
import com.example.rickandmorti.characters.AllDataFromApi
import com.example.rickandmorti.characters.Character
import com.google.gson.Gson
import com.google.gson.GsonBuilder

class GsonParse() {
    fun getResult(jsonData: String): AllDataFromApi {
        var gson : Gson
        var builder = GsonBuilder()
        gson = builder.create()
        var dataToParse: AllDataFromApi = gson.fromJson(jsonData, AllDataFromApi::class.java)
        var n : Character
        for (n in dataToParse.listCharacters){
            Log.d("name",n.urlCharacter)
        }

        return dataToParse
    }
}
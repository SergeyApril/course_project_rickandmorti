package com.example.rickandmorti

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.rickandmorti.characters.Character
import com.example.rickandmorti.network.RetroInstance
import com.example.rickandmorti.network.RetroService

class CharactersViewModel : ViewModel() {
    lateinit var retroService: RetroService
    init {
        retroService = RetroInstance().getRetroInstance().create(RetroService::class.java)
    }

    fun getListData(): kotlinx.coroutines.flow.Flow<PagingData<Character>>{
        return Pager(config = PagingConfig(pageSize = 34, maxSize = 200),pagingSourceFactory = {CharacterPagingSource(retroService)}).flow.cachedIn(viewModelScope)
    }
}
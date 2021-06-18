package com.example.rickandmorti

import android.net.Uri
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.rickandmorti.characters.Character
import com.example.rickandmorti.network.RetroService

class CharacterPagingSource(val apiService: RetroService) : PagingSource<Int,Character>() {
    override fun getRefreshKey(state: PagingState<Int, Character>): Int? {
        return state.anchorPosition
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Character> {
        return try{
            val nextPage = params.key?: FIRST_PAGE_INDEX
            val response = apiService.getDataFromAPI(nextPage)
            var nextPageNumber: Int? = null
            if (response?.info.next != null){
                val uri = Uri.parse(response.info.next)
                val nextPageQuery = uri.getQueryParameter("page")
                nextPageNumber = nextPageQuery?.toInt()
            }

            LoadResult.Page(data = response.listCharacters,
            prevKey = null,
            nextKey = nextPageNumber)
    }
        catch (e: Exception){
            LoadResult.Error(e)

        }        }
companion object{
    private const val FIRST_PAGE_INDEX = 1
}
}

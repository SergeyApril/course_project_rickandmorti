package com.example.rickandmorti

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.rickandmorti.fragments.AllCharactersFragment
import com.example.rickandmorti.fragments.AllEpisodesFragment
import com.example.rickandmorti.fragments.AllLocationsFragment

class RMFragmentAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle) :
    FragmentStateAdapter(fragmentManager, lifecycle) {
    companion object {
        private const val COUNT_FRAGMENT_WINDOW = 3
    }

    override fun getItemCount(): Int {
        return Companion.COUNT_FRAGMENT_WINDOW
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            1 -> AllEpisodesFragment()
            2 -> AllLocationsFragment()
            else -> AllCharactersFragment()
        }
    }

}
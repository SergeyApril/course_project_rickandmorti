package com.example.rickandmorti

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.viewpager2.widget.ViewPager2
import com.example.rickandmorti.adapters.CharactersAdapter
import com.example.rickandmorti.characters.AllDataFromApi
import com.example.rickandmorti.characters.Character
import com.example.rickandmorti.fragments.AllCharactersFragment
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayout.OnTabSelectedListener
import com.google.gson.Gson
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity(),CharactersAdapter.OnButtonListener {
    lateinit var tabLayout: TabLayout
    lateinit var pager2 : ViewPager2
    lateinit var rmFragmentAdapter : RMFragmentAdapter
    lateinit var gsonParse : AllDataFromApi
    companion object {
        var adapterCharacter = CharactersAdapter()
    }
    fun testLoadData(){
        gsonParse = GsonParse().getResult(DataTestClass.dataTest)
        adapterCharacter.listCharacter = gsonParse.listCharacters
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tabLayout = findViewById(R.id.tab_layout)
        pager2 = findViewById(R.id.view_pager2)

        var fm : FragmentManager = supportFragmentManager
        rmFragmentAdapter = RMFragmentAdapter(fm,lifecycle)
        pager2.adapter = rmFragmentAdapter

        tabLayout.addTab(tabLayout.newTab().setText(getString(R.string.characters)))
        tabLayout.addTab(tabLayout.newTab().setText(getString(R.string.locations)))
        tabLayout.addTab(tabLayout.newTab().setText(getString(R.string.episodes)))

        tabLayout.addOnTabSelectedListener(object : OnTabSelectedListener{
            override fun onTabReselected(tab: TabLayout.Tab?) {
            }
            override fun onTabUnselected(tab: TabLayout.Tab?) {

            }

            override fun onTabSelected(tab: TabLayout.Tab?) {
                if (tab != null) {
                    pager2.currentItem = tab.position
                }
            }
        })

        pager2.registerOnPageChangeCallback(object :ViewPager2.OnPageChangeCallback(){
            override fun onPageSelected(position: Int) {
                tabLayout.selectTab(tabLayout.getTabAt(position))
            }
        })
    testLoadData()
    }

}
package com.example.rickandmorti

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import androidx.viewpager2.widget.ViewPager2
import com.example.rickandmorti.adapters.CharactersPagesAdapter
import com.example.rickandmorti.characters.AllDataFromApi
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayout.OnTabSelectedListener

class MainActivity : AppCompatActivity(),CharactersPagesAdapter.OnButtonListener {
    lateinit var tabLayout: TabLayout
    lateinit var pager2 : ViewPager2
    lateinit var rmFragmentAdapter : RMFragmentAdapter
    lateinit var gsonParse : AllDataFromApi
    companion object {
        var adapterCharacter = CharactersPagesAdapter()
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
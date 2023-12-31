package com.arif.playstoredesign

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import androidx.activity.viewModels
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.arif.playstoredesign.databinding.ActivityMainBinding
import com.arif.playstoredesign.fragment.ShareViewModel
import com.arif.playstoredesign.fragment.Type
import com.google.android.material.navigation.NavigationBarView
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayout.OnTabSelectedListener

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var selectedTabGames: Int = 0
    private var selectedTabApps: Int = 0
    private var currentFragment: CurrentFragment = CurrentFragment.GAMES


    private val viewModel by viewModels<ShareViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
            binding = ActivityMainBinding.inflate(layoutInflater)
            setContentView(binding.root)

        setUpTab()

        val navController = findNavController(R.id.fragmentContainerView)
        navController.popBackStack()
        //NavigationUI.setupWithNavController(binding.bottomNavigationView,navController)

        viewModel.setFlag(Type.GAMES)
        binding.bottomNavigationView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.menu_games -> {
                    viewModel.setFlag(Type.GAMES)
                    binding.tabLayout.removeAllTabs()
                    currentFragment = CurrentFragment.GAMES
                    binding.tabLayout.apply {
                        removeOnTabSelectedListener(tabSelectedListener)
                        addTab(newTab().setText("For You"))
                        addTab(newTab().setText("Top Charts"))
                        addTab(newTab().setText("Kids"))
                        addTab(newTab().setText("Categories"))
                        addTab(newTab().setText("Premium"))
                        addOnTabSelectedListener(tabSelectedListener)
                        getTabAt(selectedTabGames)?.select()
                    }
                }

                R.id.menu_apps -> {
                    viewModel.setFlag(Type.APPS)
                    binding.tabLayout.removeAllTabs()
                    currentFragment = CurrentFragment.APPS
                    binding.tabLayout.apply {
                        removeOnTabSelectedListener(tabSelectedListener)
                        addTab(newTab().setText("For You"))
                        addTab(newTab().setText("Top Charts"))
                        addTab(newTab().setText("Kids"))
                        addTab(newTab().setText("Categories"))
                        addOnTabSelectedListener(tabSelectedListener)
                        getTabAt(selectedTabApps)?.select()
                    }
                }
            }

            true
        }

        val tabLayout = binding.tabLayout

        tabLayout.addOnTabSelectedListener(object : OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {

                when(tab?.position) {
                    0 -> {
                        Log.d("tab_selection", "onTabSelected: kids")
                        navController.popBackStack()
                        navController.navigate(R.id.forYouFragment)
                    }
                    1 -> {
                        Log.d("tab_selection", "onTabSelected: for you")
                        navController.popBackStack()
                        navController.navigate(R.id.topChartsFragment)
                    }
                    2 -> {
                        Log.d("tab_selection", "onTabSelected: premium")
                        navController.popBackStack()
                        navController.navigate(R.id.kidsFragment)
                    }
                    3-> {
                        Log.d("tab_selection", "onTabSelected: premium")
                        navController.popBackStack()
                        navController.navigate(R.id.categoriesFragment)
                    }
                    4 -> {
                        Log.d("tab_selection", "onTabSelected: premium")
                        navController.popBackStack()
                        navController.navigate(R.id.premiumFragment)
                    }
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {

            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
                Log.d("tab_selection", "onTabReselected: tab -> ------------tab re-selected: ${tab?.id}")
            }

        })



    }

    private fun setUpTab() {
        binding.tabLayout.apply {
            addTab(newTab().setText("For You"))
            addTab(newTab().setText("Top Charts"))
            addTab(newTab().setText("Kids"))
            addTab(newTab().setText("Categories"))
            addTab(newTab().setText("Premium"))
            addOnTabSelectedListener(tabSelectedListener)

        }
    }


    private val tabSelectedListener = object : OnTabSelectedListener {
        override fun onTabSelected(tab: TabLayout.Tab?) {
            Log.d("my_tab", "onTabSelected: tab selected listener: ${tab?.position}")
            if (currentFragment == CurrentFragment.GAMES)
                selectedTabGames = tab?.position?:0
            else
                selectedTabApps = tab?.position?:0
        }

        override fun onTabUnselected(tab: TabLayout.Tab?) {

        }

        override fun onTabReselected(tab: TabLayout.Tab?) {

        }
    }
}

enum class CurrentFragment {
    GAMES,APPS
}
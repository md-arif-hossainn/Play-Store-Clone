package com.arif.playstoredesign.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.arif.playstoredesign.R
import com.arif.playstoredesign.adapter.AppsTopChatsAdapter
import com.arif.playstoredesign.adapter.CategoriesAdapter
import com.arif.playstoredesign.data_model.DataSet
import com.arif.playstoredesign.databinding.FragmentCategoriesBinding
import com.arif.playstoredesign.databinding.FragmentForYouBinding


class CategoriesFragment : Fragment() {

    private lateinit var binding: FragmentCategoriesBinding
    private val viewModel by activityViewModels<ShareViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCategoriesBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.flag.observe(viewLifecycleOwner) {
            when(it) {
                Type.GAMES -> {
                    binding.gamesLayoutID.root.visibility = View.VISIBLE
                    binding.appLayoutID.root.visibility = View.GONE

                    binding.gamesLayoutID.gameCategoriesRV.layoutManager = LinearLayoutManager(requireContext())
                    val gameCategoriesAdapter = CategoriesAdapter(DataSet.categoryData) // Replace DataSet.parentList with your data
                    binding.gamesLayoutID.gameCategoriesRV.adapter = gameCategoriesAdapter
                }
                Type.APPS -> {
                    binding.gamesLayoutID.root.visibility = View.GONE
                    binding.appLayoutID.root.visibility = View.VISIBLE


                    binding.appLayoutID.appCategoriesRV.layoutManager = LinearLayoutManager(requireContext())
                    val appsCategoriesAdapter = CategoriesAdapter(DataSet.categoryData) // Replace DataSet.parentList with your data
                    binding.appLayoutID.appCategoriesRV.adapter = appsCategoriesAdapter
                }
                else -> {}
            }
        }
    }

}
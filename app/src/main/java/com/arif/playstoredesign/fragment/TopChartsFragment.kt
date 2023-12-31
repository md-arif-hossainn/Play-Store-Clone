package com.arif.playstoredesign.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.arif.playstoredesign.R
import com.arif.playstoredesign.adapter.AppsTopChatsAdapter
import com.arif.playstoredesign.data_model.DataSet
import com.arif.playstoredesign.data_model.RowAppDataModel
import com.arif.playstoredesign.databinding.FragmentCategoriesBinding
import com.arif.playstoredesign.databinding.FragmentTopChartsBinding
import com.arif.playstoredesign.fragment_dialogue.CategoriesFragmentDialogue
import com.arif.playstoredesign.fragment_dialogue.TopFreeBottomSheets


class TopChartsFragment : Fragment() {

    private lateinit var binding: FragmentTopChartsBinding
    private val viewModel by activityViewModels<ShareViewModel>()
    private val topChartAdapter by lazy { AppsTopChatsAdapter(ArrayList()) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTopChartsBinding.inflate(inflater,container,false)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        Log.d("top_db", "onViewCreated: called")

        //initRv()

        viewModel.flag.observe(viewLifecycleOwner) {
            when(it) {
                Type.GAMES -> {
                    Log.d("top_db", "onViewCreated: games")
                    binding.gamesLayoutID.root.visibility = View.VISIBLE
                    binding.appsLayoutID.root.visibility = View.GONE


                    binding.gamesLayoutID.gameTopChartsRV.layoutManager = LinearLayoutManager(requireContext())
                    val gameTopChartAdapter = AppsTopChatsAdapter(DataSet.gameTopChart) // Replace DataSet.parentList with your data
                    binding.gamesLayoutID.gameTopChartsRV.adapter = gameTopChartAdapter


                    binding.gamesLayoutID.gameCategoriesID.setOnClickListener {
                        val categoriesDialogue = CategoriesFragmentDialogue()
                        categoriesDialogue.show(requireActivity().supportFragmentManager,"_")
                    }

                    binding.gamesLayoutID.gameTopFreeID.setOnClickListener {
                        val bottomSheets = TopFreeBottomSheets()
                        bottomSheets.show(requireActivity().supportFragmentManager,"ModalBottomSheet")

                    }

                }
                Type.APPS -> {
                    Log.d("top_db", "onViewCreated: apps")
                    binding.gamesLayoutID.root.visibility = View.GONE
                    binding.appsLayoutID.root.visibility = View.VISIBLE

                    binding.appsLayoutID.categoriesID.setOnClickListener {
                        val categoriesDialogue = CategoriesFragmentDialogue()
                        categoriesDialogue.show(requireActivity().supportFragmentManager,"_")
                    }

                    binding.appsLayoutID.topFreeID.setOnClickListener {
                        val bottomSheets = TopFreeBottomSheets()
                        bottomSheets.show(requireActivity().supportFragmentManager,"ModalBottomSheet")

                    }

                    binding.appsLayoutID.appTopChartsRV.layoutManager = LinearLayoutManager(requireContext())
                    val appsTopChartAdapter = AppsTopChatsAdapter(DataSet.rowAppData) // Replace DataSet.parentList with your data
                    binding.appsLayoutID.appTopChartsRV.adapter = appsTopChartAdapter
                }
                else -> {}
            }
        }


    }

    private fun initRv() {
        binding.gamesLayoutID.gameTopChartsRV.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = topChartAdapter
        }

        binding.appsLayoutID.appTopChartsRV.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = topChartAdapter
        }
    }

}
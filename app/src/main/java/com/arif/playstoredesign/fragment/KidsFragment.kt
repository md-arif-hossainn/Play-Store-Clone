package com.arif.playstoredesign.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.arif.playstoredesign.R
import com.arif.playstoredesign.adapter.SuggestAdapter
import com.arif.playstoredesign.adapter.SuggestForYouAdapter
import com.arif.playstoredesign.data_model.DataSet
import com.arif.playstoredesign.databinding.FragmentCategoriesBinding
import com.arif.playstoredesign.databinding.FragmentKidsBinding


class KidsFragment : Fragment() {

    private lateinit var binding: FragmentKidsBinding
    private val viewModel by activityViewModels<ShareViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentKidsBinding.inflate(inflater,container,false)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.flag.observe(viewLifecycleOwner) {
            when(it) {
                Type.GAMES -> {
                    binding.gamesLayoutID.root.visibility = View.VISIBLE
                    binding.appsLayoutID.root.visibility = View.GONE

                    binding.gamesLayoutID.editVideoTV.headerNameTV.text = "Edit videos like a pro"
                    binding.gamesLayoutID.editRV.layoutManager = LinearLayoutManager(requireContext(),
                        LinearLayoutManager.HORIZONTAL,false)
                    val offlineAdapter = SuggestAdapter(DataSet.editVideoAppData) // Replace DataSet.parentList with your data
                    binding.gamesLayoutID.editRV.adapter = offlineAdapter


                    binding.gamesLayoutID.suggestForYouTV.headerNameTV.text = "Suggested for you"

                    binding.gamesLayoutID.suggestRV.layoutManager = LinearLayoutManager(requireContext(),
                        LinearLayoutManager.HORIZONTAL,false)
                    val stylizedAdapter = SuggestAdapter(DataSet.premiumAppData) // Replace DataSet.parentList with your data
                    binding.gamesLayoutID.suggestRV.adapter = stylizedAdapter


                    binding.gamesLayoutID.basedOnRecentTV.headerNameTV.text = "Based on your recent activity"
                    binding.gamesLayoutID.basedOnRecentRV.layoutManager = LinearLayoutManager(requireContext(),
                        LinearLayoutManager.HORIZONTAL,false)
                    val recentData = SuggestAdapter(DataSet.recentAppData) // Replace DataSet.parentList with your data
                    binding.gamesLayoutID.basedOnRecentRV.adapter = recentData


                    binding.gamesLayoutID.recommendedTV.headerNameTV.text = "Recommended for you"
                    binding.gamesLayoutID.recommendedRV.layoutManager = LinearLayoutManager(requireContext(),
                        LinearLayoutManager.HORIZONTAL,false)
                    val recommendedData = SuggestAdapter(DataSet.recommendAppData) // Replace DataSet.parentList with your data
                    binding.gamesLayoutID.recommendedRV.adapter = recommendedData


                    binding.gamesLayoutID.newsMagazineTV.headerNameTV.text = "News & magazines"

                    binding.gamesLayoutID.newsMagazineRV.layoutManager = LinearLayoutManager(requireContext(),
                        LinearLayoutManager.HORIZONTAL,false)
                    val magazine = SuggestAdapter(DataSet.premiumAppData) // Replace DataSet.parentList with your data
                    binding.gamesLayoutID.newsMagazineRV.adapter = magazine

                    binding.gamesLayoutID.suggestForYouTV2.headerNameTV.text = "Suggested for you"


                    binding.gamesLayoutID.suggestRV2.layoutManager = LinearLayoutManager(requireContext(),
                        LinearLayoutManager.HORIZONTAL,false)
                    val suggest2 = SuggestForYouAdapter(DataSet.suggestForYouData) // Replace DataSet.parentList with your data
                    binding.gamesLayoutID.suggestRV2.adapter = suggest2


                    binding.gamesLayoutID.justUpdateTV.headerNameTV.text = "Just updated"

                    binding.gamesLayoutID.justUpdateRV.layoutManager = LinearLayoutManager(requireContext(),
                        LinearLayoutManager.HORIZONTAL,false)
                    val update = SuggestAdapter(DataSet.editVideoAppData) // Replace DataSet.parentList with your data
                    binding.gamesLayoutID.justUpdateRV.adapter = update


                }
                Type.APPS -> {
                    binding.gamesLayoutID.root.visibility = View.GONE
                    binding.appsLayoutID.root.visibility = View.VISIBLE

                    binding.appsLayoutID.editVideoTV.headerNameTV.text = "Edit videos like a pro"
                    binding.appsLayoutID.editRV.layoutManager = LinearLayoutManager(requireContext(),
                        LinearLayoutManager.HORIZONTAL,false)
                    val offlineAdapter = SuggestAdapter(DataSet.editVideoAppData) // Replace DataSet.parentList with your data
                    binding.appsLayoutID.editRV.adapter = offlineAdapter


                    binding.appsLayoutID.suggestForYouTV.headerNameTV.text = "Suggested for you"

                    binding.appsLayoutID.suggestRV.layoutManager = LinearLayoutManager(requireContext(),
                        LinearLayoutManager.HORIZONTAL,false)
                    val stylizedAdapter = SuggestAdapter(DataSet.premiumAppData) // Replace DataSet.parentList with your data
                    binding.appsLayoutID.suggestRV.adapter = stylizedAdapter


                    binding.appsLayoutID.basedOnRecentTV.headerNameTV.text = "Based on your recent activity"
                    binding.appsLayoutID.basedOnRecentRV.layoutManager = LinearLayoutManager(requireContext(),
                        LinearLayoutManager.HORIZONTAL,false)
                    val recentData = SuggestAdapter(DataSet.recentAppData) // Replace DataSet.parentList with your data
                    binding.appsLayoutID.basedOnRecentRV.adapter = recentData


                    binding.appsLayoutID.recommendedTV.headerNameTV.text = "Recommended for you"
                    binding.appsLayoutID.recommendedRV.layoutManager = LinearLayoutManager(requireContext(),
                        LinearLayoutManager.HORIZONTAL,false)
                    val recommendedData = SuggestAdapter(DataSet.recommendAppData) // Replace DataSet.parentList with your data
                    binding.appsLayoutID.recommendedRV.adapter = recommendedData


                    binding.appsLayoutID.newsMagazineTV.headerNameTV.text = "News & magazines"

                    binding.appsLayoutID.newsMagazineRV.layoutManager = LinearLayoutManager(requireContext(),
                        LinearLayoutManager.HORIZONTAL,false)
                    val magazine = SuggestAdapter(DataSet.premiumAppData) // Replace DataSet.parentList with your data
                    binding.appsLayoutID.newsMagazineRV.adapter = magazine

                    binding.appsLayoutID.suggestForYouTV2.headerNameTV.text = "Suggested for you"


                    binding.appsLayoutID.suggestRV2.layoutManager = LinearLayoutManager(requireContext(),
                        LinearLayoutManager.HORIZONTAL,false)
                    val suggest2 = SuggestForYouAdapter(DataSet.suggestForYouData) // Replace DataSet.parentList with your data
                    binding.appsLayoutID.suggestRV2.adapter = suggest2


                    binding.appsLayoutID.justUpdateTV.headerNameTV.text = "Just updated"

                    binding.appsLayoutID.justUpdateRV.layoutManager = LinearLayoutManager(requireContext(),
                        LinearLayoutManager.HORIZONTAL,false)
                    val update = SuggestAdapter(DataSet.editVideoAppData) // Replace DataSet.parentList with your data
                    binding.appsLayoutID.justUpdateRV.adapter = update
                }
                else -> {}
            }
        }

    }

}
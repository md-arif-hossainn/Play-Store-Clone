package com.arif.playstoredesign.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.arif.playstoredesign.adapter.PremiumAdapter
import com.arif.playstoredesign.data_model.DataSet
import com.arif.playstoredesign.databinding.FragmentPremiumBinding


class PremiumFragment : Fragment() {

    private lateinit var binding: FragmentPremiumBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding  = FragmentPremiumBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.recommendedRV.layoutManager = LinearLayoutManager(requireContext(),
            LinearLayoutManager.HORIZONTAL,false)
        val premiumAdapter = PremiumAdapter(DataSet.editVideoAppData) // Replace DataSet.parentList with your data
        binding.recommendedRV.adapter = premiumAdapter


        binding.offlineRV.layoutManager = LinearLayoutManager(requireContext(),
            LinearLayoutManager.HORIZONTAL,false)
        val offlineAdapter = PremiumAdapter(DataSet.premiumAppData) // Replace DataSet.parentList with your data
        binding.offlineRV.adapter = offlineAdapter


        binding.stylizedRV.layoutManager = LinearLayoutManager(requireContext(),
            LinearLayoutManager.HORIZONTAL,false)
        val stylizedAdapter = PremiumAdapter(DataSet.recommendAppData) // Replace DataSet.parentList with your data
        binding.stylizedRV.adapter = stylizedAdapter

        binding.familyRV.layoutManager = LinearLayoutManager(requireContext(),
            LinearLayoutManager.HORIZONTAL,false)
        val familyAdapter = PremiumAdapter(DataSet.recentAppData) // Replace DataSet.parentList with your data
        binding.familyRV.adapter = familyAdapter

        binding.casualRV.layoutManager = LinearLayoutManager(requireContext(),
            LinearLayoutManager.HORIZONTAL,false)
        val casualAdapter = PremiumAdapter(DataSet.editVideoAppData) // Replace DataSet.parentList with your data
        binding.casualRV.adapter = casualAdapter

        binding.multiRV.layoutManager = LinearLayoutManager(requireContext(),
            LinearLayoutManager.HORIZONTAL,false)
        val multiAdapter = PremiumAdapter(DataSet.premiumAppData) // Replace DataSet.parentList with your data
        binding.multiRV.adapter = multiAdapter
    }

}
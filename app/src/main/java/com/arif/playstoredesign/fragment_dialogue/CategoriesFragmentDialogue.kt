package com.arif.playstoredesign.fragment_dialogue

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import androidx.fragment.app.DialogFragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.arif.playstoredesign.R
import com.arif.playstoredesign.adapter.CategoriesAdapter
import com.arif.playstoredesign.data_model.DataSet
import com.arif.playstoredesign.databinding.CategoriesFragmentDialogueBinding
import com.arif.playstoredesign.databinding.FragmentCategoriesBinding

class CategoriesFragmentDialogue() : DialogFragment() {

    private lateinit var binding: CategoriesFragmentDialogueBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = CategoriesFragmentDialogueBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.cancelButton.setOnClickListener {
            dialog?.dismiss()
        }

        binding.categoriesDialogueRV.layoutManager = LinearLayoutManager(requireContext())
        val appsCategoriesAdapter = CategoriesAdapter(DataSet.categoryDialogData) // Replace DataSet.parentList with your data
        binding.categoriesDialogueRV.adapter = appsCategoriesAdapter


    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val dialog = super.onCreateDialog(savedInstanceState)
        dialog.window?.requestFeature(Window.FEATURE_NO_TITLE)
        dialog.window?.setBackgroundDrawableResource(android.R.color.transparent)
        return dialog
    }

    override fun onStart() {
        super.onStart()
        val dialog = dialog
        if (dialog != null) {
            val width = ViewGroup.LayoutParams.MATCH_PARENT
            val height = ViewGroup.LayoutParams.MATCH_PARENT
            dialog.window!!.setLayout(width, height)
        }
    }
}
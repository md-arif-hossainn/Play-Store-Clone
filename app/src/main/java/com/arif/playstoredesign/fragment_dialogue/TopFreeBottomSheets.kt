package com.arif.playstoredesign.fragment_dialogue

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.arif.playstoredesign.databinding.TopFreeBottomSheetBinding
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class TopFreeBottomSheets: BottomSheetDialogFragment() {

    private lateinit var binding: TopFreeBottomSheetBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = TopFreeBottomSheetBinding.inflate(inflater)
        return binding.root
    }

//    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
//        // used to show the bottom sheet dialog
//        dialog?.setOnShowListener { it ->
//            val d = it as BottomSheetDialog
//            val bottomSheet = d.findViewById<View>(com.google.android.material.R.id.design_bottom_sheet)
//            bottomSheet?.let {
//                val behavior = BottomSheetBehavior.from(it)
//                behavior.state = BottomSheetBehavior.STATE_EXPANDED
//            }
//        }
//        return super.onCreateDialog(savedInstanceState)
//    }


    companion object {
        const val TAG = "ModalBottomSheet"
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}


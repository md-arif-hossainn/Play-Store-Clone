package com.arif.playstoredesign.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.arif.playstoredesign.data_model.ViewTypeDataModel
import com.arif.playstoredesign.databinding.GameLargeAppDesignBinding
import com.arif.playstoredesign.databinding.ThreeCardDesignBinding

const val ITEM_WITH_THREE_POSTER = 0
const val ITEM_WITHOUT_THREE_POSTER = 1
class ViewTypeAdapter (private val mList: List<ViewTypeDataModel>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    inner class ItemWithThreePosterViewHolder(private val binding: ThreeCardDesignBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bindThreePosterView(dataItem: ViewTypeDataModel) {
            binding.image1.setImageResource(dataItem.appPoster1)
            dataItem.appPoster2?.let { binding.image2.setImageResource(it) }
            dataItem.appPoster3?.let { binding.image3.setImageResource(it) }

        }
    }

    inner class ItemWithoutThreePosterViewHolder(private val binding: GameLargeAppDesignBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bindWithoutThreePosterView(dataItem: ViewTypeDataModel) {
            binding.gifImageIV.setImageResource(dataItem.appPoster1)
            binding.image2.setImageResource(dataItem.mainPoster)

        }
    }

    override fun getItemViewType(position: Int): Int {

        if (mList[position].appPoster2 != null && mList[position].appPoster3 != null) {
            return ITEM_WITH_THREE_POSTER
        } else {
            return ITEM_WITHOUT_THREE_POSTER
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        if (viewType == ITEM_WITH_THREE_POSTER) {
            val binding =
                ThreeCardDesignBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            return ItemWithThreePosterViewHolder(binding)

        } else {
            val binding =
                GameLargeAppDesignBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            return ItemWithoutThreePosterViewHolder(binding)
        }

    }

    override fun getItemCount(): Int {
        return mList.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        if (getItemViewType(position) == ITEM_WITH_THREE_POSTER) {
            (holder as ItemWithThreePosterViewHolder).bindThreePosterView(mList[position])
        } else {
            (holder as ItemWithoutThreePosterViewHolder).bindWithoutThreePosterView(mList[position])
        }
    }
}
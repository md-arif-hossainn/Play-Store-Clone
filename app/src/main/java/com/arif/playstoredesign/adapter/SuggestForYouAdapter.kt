package com.arif.playstoredesign.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.arif.playstoredesign.data_model.RowAppDataModel
import com.arif.playstoredesign.data_model.ThreePosterDataModel
import com.arif.playstoredesign.databinding.ThreeAppDesignBinding

class SuggestForYouAdapter(private var dataList: ArrayList<ThreePosterDataModel>) :
    RecyclerView.Adapter<SuggestForYouAdapter.MyViewHolder>() {

    inner class MyViewHolder(val binding: ThreeAppDesignBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        val binding = ThreeAppDesignBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(binding)

    }

    override fun getItemCount(): Int {

        return dataList.size

    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val item = dataList[position]
        holder.binding.apply {
            appIconIV.setImageResource(item.appPoster1)
            appName.text = item.appPoster1Name
            appIconIV2.setImageResource(item.appPoster2)
            appName2.text = item.appPoster2Name
            appIconIV3.setImageResource(item.appPoster3)
            appName3.text = item.appPoster3Name
        }

    }
}
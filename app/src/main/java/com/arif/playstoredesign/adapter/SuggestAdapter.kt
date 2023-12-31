package com.arif.playstoredesign.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.arif.playstoredesign.data_model.RowAppDataModel
import com.arif.playstoredesign.databinding.CommonAppDesignBinding

class SuggestAdapter (private var dataList: ArrayList<RowAppDataModel>) :
    RecyclerView.Adapter<SuggestAdapter.MyViewHolder>() {

    inner class MyViewHolder(val binding: CommonAppDesignBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        val binding = CommonAppDesignBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(binding)

    }

    override fun getItemCount(): Int {

        return dataList.size

    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val item = dataList[position]
        holder.binding.apply {
            appImage.setImageResource(item.appPoster)
            appNameTV.text = item.name
        }

    }
}
package com.arif.playstoredesign.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.arif.playstoredesign.data_model.RowAppDataModel
import com.arif.playstoredesign.databinding.RowAppDesignBinding

class AppsTopChatsAdapter(private var dataList: ArrayList<RowAppDataModel>) :
    RecyclerView.Adapter<AppsTopChatsAdapter.MyViewHolder>() {

    inner class MyViewHolder(val binding: RowAppDesignBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        val binding = RowAppDesignBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(binding)


    }

    override fun getItemCount(): Int {

        return dataList.size

    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.binding.appIconIV.setImageResource(dataList[position].appPoster)
        holder.binding.appName.text = dataList[position].name
        holder.binding.numberTV.text = "${dataList[position].id}"

    }
}
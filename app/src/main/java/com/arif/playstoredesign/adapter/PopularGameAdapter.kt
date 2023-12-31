package com.arif.playstoredesign.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.recyclerview.widget.RecyclerView
import com.arif.playstoredesign.data_model.RowAppDataModel
import com.arif.playstoredesign.data_model.TwoPosterDataModel
import com.arif.playstoredesign.databinding.GameLargeAppDesignBinding
import com.arif.playstoredesign.utils.setImage

class PopularGameAdapter (private var dataList: ArrayList<TwoPosterDataModel>) :
    RecyclerView.Adapter<PopularGameAdapter.MyViewHolder>() {

    inner class MyViewHolder(val binding: GameLargeAppDesignBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        val binding = GameLargeAppDesignBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(binding)

    }

    override fun getItemCount(): Int {

        return dataList.size

    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val item = dataList[position]
        holder.binding.apply {
            gifImageIV.setImageResource(item.appPoster1)
            image2.setImageResource(item.mainPoster)
            appNameTV.text = item.name




        }

    }
}
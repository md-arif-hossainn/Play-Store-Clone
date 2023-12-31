package com.arif.playstoredesign.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.arif.playstoredesign.data_model.RowAppDataModel
import com.arif.playstoredesign.databinding.CategoriesDesignBinding
import com.arif.playstoredesign.databinding.RowAppDesignBinding

class CategoriesAdapter (private var dataList: ArrayList<RowAppDataModel>) :
    RecyclerView.Adapter<CategoriesAdapter.MyViewHolder>() {

    inner class MyViewHolder(val binding: CategoriesDesignBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        val binding = CategoriesDesignBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(binding)

    }

    override fun getItemCount(): Int {

        return dataList.size

    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val item = dataList[position]
        holder.binding.apply {
            imageIV.setImageResource(item.appPoster)
            appCategoriesID.text = item.name
            lineID.visibility = if (item.hideDivider) View.GONE else View.VISIBLE
            root.setOnClickListener {

            }
        }

    }
}
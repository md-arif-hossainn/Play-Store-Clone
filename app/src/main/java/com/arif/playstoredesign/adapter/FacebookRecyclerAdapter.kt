package com.arif.playstoredesign.adapter

import android.content.Context
import android.graphics.Outline
import android.os.Build
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewOutlineProvider
import androidx.annotation.RequiresApi
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.arif.playstoredesign.R
import com.arif.playstoredesign.databinding.VideoPlayerDesignBinding
import com.arif.playstoredesign.models.MediaObject
import com.arif.playstoredesign.utils_video.PlayerStateCallback
import com.arif.playstoredesign.utils_video.PlayerViewAdapter.Companion.releaseRecycledPlayers
import com.google.android.exoplayer2.Player
import java.util.*

/**
 * A custom adapter create by Mostafa Anter.
 */
class FacebookRecyclerAdapter(
    private val mContext: Context,
    private var modelList: ArrayList<MediaObject>) : RecyclerView.Adapter<RecyclerView.ViewHolder>(),
    PlayerStateCallback {

    private var mItemClickListener: OnItemClickListener? =
        null

    fun updateList(modelList: ArrayList<MediaObject>) {
        this.modelList = modelList
        notifyDataSetChanged()
    }

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onCreateViewHolder(
        viewGroup: ViewGroup,
        viewType: Int
    ): VideoPlayerViewHolder {
        val binding: VideoPlayerDesignBinding = DataBindingUtil.inflate(LayoutInflater.from(viewGroup.context)
            , R.layout.video_player_design, viewGroup, false)

        //corner radius
        binding.itemVideoExoplayer.outlineProvider = object : ViewOutlineProvider() {
            override fun getOutline(view: View, outline: Outline) {
                outline.setRoundRect(0, 0, view.width, view.height, 25f)
            }
        }
        binding.itemVideoExoplayer.clipToOutline = true

//        val thumbnailImageView: ImageView = binding.thumbnail
//
//        // Set corner radius
//        val cornerRadius = 25f // or any other value you prefer
//
//        // Create a GradientDrawable with rounded corners
//        val gradientDrawable = GradientDrawable()
//        gradientDrawable.shape = GradientDrawable.RECTANGLE
//        gradientDrawable.setColor(Color.WHITE) // Set the background color if needed
//        gradientDrawable.cornerRadius = cornerRadius
//
//        // Set the GradientDrawable as the background of the ImageView
//        thumbnailImageView.background = gradientDrawable

        return VideoPlayerViewHolder(binding)
    }

    override fun onBindViewHolder(
        holder: RecyclerView.ViewHolder,
        position: Int) {

        //TODO you can change according to your need
        //Here you can fill your row view
        if (holder is VideoPlayerViewHolder) {
            val model = getItem(position)
            val genericViewHolder = holder

            // send data to view holder
            genericViewHolder.onBind(model)
        }
    }

    override fun onViewRecycled(holder: RecyclerView.ViewHolder) {
        val position = holder.adapterPosition
        releaseRecycledPlayers(position)
        super.onViewRecycled(holder)
    }

    override fun getItemCount(): Int {
        return modelList.size
    }

    private fun getItem(position: Int): MediaObject {
        return modelList[position]
    }

    fun SetOnItemClickListener(mItemClickListener: OnItemClickListener?) {
        this.mItemClickListener = mItemClickListener
    }

    interface OnItemClickListener {
        fun onItemClick(
            view: View?,
            position: Int,
            model: MediaObject?
        )
    }

    inner class VideoPlayerViewHolder(private val binding: VideoPlayerDesignBinding) : RecyclerView.ViewHolder(binding.root) {

        fun onBind(model: MediaObject) {
            // handel on item click
            binding.root.setOnClickListener {
                mItemClickListener!!.onItemClick(
                    it,
                    adapterPosition,
                    model
                )
            }

            binding.apply {
                dataModel = model
                callback = this@FacebookRecyclerAdapter
                index = adapterPosition
                executePendingBindings()
            }


        }
    }

    override fun onVideoDurationRetrieved(duration: Long, player: Player) {}

    override fun onVideoBuffering(player: Player) {}

    override fun onStartedPlaying(player: Player) {
        Log.d("playvideo", "staaaart" + player.contentDuration)

    }


    override fun onFinishedPlaying(player: Player) {}
}
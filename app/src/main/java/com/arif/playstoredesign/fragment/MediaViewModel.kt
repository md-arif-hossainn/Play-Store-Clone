package com.arif.playstoredesign.fragment

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.arif.playstoredesign.models.MediaObject
import com.arif.playstoredesign.models.reposatories.MediaRepo

class MediaViewModel: ViewModel() {
    private val mediaData: MutableLiveData<MutableList<MediaObject>> = MediaRepo().getMediaData()
    fun getMedia(): MutableLiveData<MutableList<MediaObject>>{
        return mediaData
    }
}
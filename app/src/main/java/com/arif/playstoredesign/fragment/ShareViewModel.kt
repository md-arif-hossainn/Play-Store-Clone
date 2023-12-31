package com.arif.playstoredesign.fragment

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ShareViewModel: ViewModel() {
    val flag = MutableLiveData<Type>()

    fun setFlag(type: Type) {
        flag.value = type
    }

}

enum class Type {
    GAMES,APPS
}
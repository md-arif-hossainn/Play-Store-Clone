package com.arif.playstoredesign.models.reposatories

import androidx.lifecycle.MutableLiveData
import com.arif.playstoredesign.models.MediaObject
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.kotlin.addTo

class MediaRepo {
    // dummy data for get list of media objects
    public fun getMediaData(): MutableLiveData<MutableList<MediaObject>> {
        val data: MutableLiveData<MutableList<MediaObject>> = MutableLiveData()
        val dataObservable = Observable.create<MutableList<MediaObject>> {
            it.onNext(
                mutableListOf(
                    MediaObject(
                        "WhatsAPP communication",
                        "https://storage.googleapis.com/exoplayer-test-media-0/BigBuckBunny_320x180.mp4",
                        "https://www.webwise.ie/wp-content/uploads/2017/12/Whatsapp.jpg",
                        "High Quality Video Calling"
                    ),
                    MediaObject(
                        "Telegram video call",
                        "https://storage.googleapis.com/exoplayer-test-media-0/BigBuckBunny_320x180.mp4",
                        "https://upload.wikimedia.org/wikipedia/commons/thumb/8/83/Telegram_2019_Logo.svg/800px-Telegram_2019_Logo.svg.png",
                        "Communication Video Call"
                    ),
                    MediaObject(
                        "Clash Of Clans",
                        "https://storage.googleapis.com/exoplayer-test-media-0/BigBuckBunny_320x180.mp4",
                        "https://play-lh.googleusercontent.com/LByrur1mTmPeNr0ljI-uAUcct1rzmTve5Esau1SwoAzjBXQUby6uHIfHbF9TAT51mgHm",
                        "HBO GO now works"
                    ),
                    MediaObject(
                        "Temple run",
                        "https://storage.googleapis.com/exoplayer-test-media-0/BigBuckBunny_320x180.mp4",
                        "https://assets-prd.ignimgs.com/2023/04/02/templerun2-1680461914458.jpg",
                        "Google Play Games"
                    ),
                    MediaObject(
                        "Battle ship",
                        "https://storage.googleapis.com/exoplayer-test-media-0/BigBuckBunny_320x180.mp4",
                        "https://t3.ftcdn.net/jpg/05/58/90/40/360_F_558904050_0Pdr8120v9kb9bRlWqmBQ7XHSMUaThKo.jpg",
                        "Introducing Chromecast"
                    )
                )
            )

            it.onComplete()
        }

        dataObservable.subscribe {
            data.value = it
        }.addTo(CompositeDisposable())

        return data
    }
}
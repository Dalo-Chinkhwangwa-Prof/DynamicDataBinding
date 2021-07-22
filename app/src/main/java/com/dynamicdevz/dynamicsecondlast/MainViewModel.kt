package com.dynamicdevz.dynamicsecondlast

import android.os.Handler
import android.os.Looper
import androidx.databinding.BaseObservable
import androidx.databinding.Bindable

class MainViewModel: BaseObservable() {

    @get: Bindable
    var name: String = "Some........name"
        set(value) {
            field = value
            notifyPropertyChanged(BR.name)
        }

    fun makeAPICall() {

        Handler(Looper.getMainLooper()).postDelayed(
            {
                name = "Lord of The Flies"
            },
            3000
        )


    }

}
package com.itgosolutions.demomvc.ui.compositedisposable

import com.itgosolutions.demomvc.ui.common.ObservableBaseView

interface CompositeDisposableView : ObservableBaseView<CompositeDisposableView.Listener> {

    interface Listener {
        fun onStartTimerClicked()
        fun onStopTimerClicked()
    }

    fun setTimerText(timerText: String)
    fun clearTimerText()
}
package com.itgosolutions.demomvc.ui.compositedisposable

import android.support.v7.widget.AppCompatButton
import android.support.v7.widget.AppCompatTextView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.itgosolutions.demomvc.R
import com.itgosolutions.demomvc.ui.common.ObservableBaseViewImpl

class CompositeDisposableViewImpl(
    inflater: LayoutInflater,
    parent: ViewGroup?
) : ObservableBaseViewImpl<CompositeDisposableView.Listener>(), CompositeDisposableView {

    private val buttonStartTimer: AppCompatButton
    private val buttonStopTimer: AppCompatButton
    private val textViewTimerText: AppCompatTextView

    init {
        setRootView(inflater.inflate(R.layout.layout_composite_disposable, parent, false))

        buttonStartTimer = findViewById(R.id.buttonStartTimer)
        buttonStopTimer = findViewById(R.id.buttonStopTimer)
        textViewTimerText = findViewById(R.id.textViewTimerText)

        buttonStartTimer.setOnClickListener { getListeners().forEach { listener -> listener.onStartTimerClicked() } }
        buttonStopTimer.setOnClickListener { getListeners().forEach { listener -> listener.onStopTimerClicked() } }
    }

    override fun setTimerText(timerText: String) {
        textViewTimerText.text = timerText
    }

    override fun clearTimerText() {
        textViewTimerText.text = ""
    }
}
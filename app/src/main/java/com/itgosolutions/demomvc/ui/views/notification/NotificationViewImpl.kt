package com.itgosolutions.demomvc.ui.views.notification

import android.animation.ObjectAnimator
import android.support.v7.widget.AppCompatImageButton
import android.support.v7.widget.AppCompatTextView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.itgosolutions.demomvc.R
import com.itgosolutions.demomvc.ui.common.ObservableBaseViewImpl

class NotificationViewImpl(
    inflater: LayoutInflater,
    parent: ViewGroup?
) : ObservableBaseViewImpl<NotificationView.Listener>(), NotificationView {

    private val textViewNotificationTitle: AppCompatTextView
    private val imageButtonCloseNotification: AppCompatImageButton

    init {
        setRootView(inflater.inflate(R.layout.layout_notification, parent, false))

        getRootView().setOnClickListener {  }

        textViewNotificationTitle = findViewById(R.id.textViewNotificationTitle)
        imageButtonCloseNotification = findViewById(R.id.imageButtonCloseNotification)
        imageButtonCloseNotification.setOnClickListener {
            println("Clicked")
            getListeners().forEach { listener -> listener.onCloseNotificationClicked() }
        }
    }

    override fun bindTitle(title: String) {
        textViewNotificationTitle.text = title
    }

    override fun animate() {
        getRootView().visibility = View.INVISIBLE
        ObjectAnimator.ofFloat(getRootView(), "translationY", -100f, 0f).apply {
            duration = 200
            start()
        }
        getRootView().visibility = View.VISIBLE
    }
}
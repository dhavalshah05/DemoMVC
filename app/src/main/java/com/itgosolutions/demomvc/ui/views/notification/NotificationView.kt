package com.itgosolutions.demomvc.ui.views.notification

import com.itgosolutions.demomvc.ui.common.ObservableBaseView

interface NotificationView : ObservableBaseView<NotificationView.Listener> {

    interface Listener {
        fun onCloseNotificationClicked()
    }

    fun bindTitle(title: String)
    fun animate()
}
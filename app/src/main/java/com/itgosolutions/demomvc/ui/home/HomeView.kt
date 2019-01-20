package com.itgosolutions.demomvc.ui.home

import android.support.annotation.IdRes
import com.itgosolutions.demomvc.ui.common.ObservableBaseView

interface HomeView : ObservableBaseView<HomeView.Listener> {

    interface Listener {
        fun onFirstScreenClicked()
        fun onSecondScreenClicked()
    }

    @IdRes
    fun getFrameContentId(): Int

    fun setScreenTitle(title: String)

    fun isDrawerOpen(): Boolean
    fun closeDrawer()
}
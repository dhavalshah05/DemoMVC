package com.itgosolutions.demomvc.ui.views.toolbar

import android.support.annotation.ColorRes
import android.support.annotation.StringRes
import com.itgosolutions.demomvc.ui.common.BaseView

interface ToolbarView : BaseView {

    interface NavigateBackPressedListener {
        fun onNavigateBackPressed()
    }

    interface HamburgerMenuClickedListener {
        fun onHamburgerMenuClicked()
    }

    fun setTitle(title: String)
    fun setTitle(@StringRes id: Int)

    fun setBackgroundColor(@ColorRes id: Int)

    fun enableBackButtonAndListen(listener: NavigateBackPressedListener)

    fun disableBackButton()

    fun enableHamburgerMenuAndListen(listener: HamburgerMenuClickedListener)

    fun disableHamburgerMenu()
}
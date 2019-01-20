package com.itgosolutions.demomvc.ui.common

import android.support.annotation.StringRes

class ScreenTitleHelper(private val baseActivity: BaseActivity) {

    fun setScreenTitle(title: String) {
        baseActivity.setScreenTitle(title)
    }

    fun setScreenTitle(@StringRes id: Int) {
        baseActivity.setScreenTitle(id)
    }

}
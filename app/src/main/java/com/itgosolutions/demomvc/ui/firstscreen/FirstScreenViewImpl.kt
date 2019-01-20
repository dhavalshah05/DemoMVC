package com.itgosolutions.demomvc.ui.firstscreen

import android.view.LayoutInflater
import android.view.ViewGroup
import com.itgosolutions.demomvc.R
import com.itgosolutions.demomvc.ui.common.BaseViewImpl

class FirstScreenViewImpl(inflater: LayoutInflater, parent: ViewGroup?) : BaseViewImpl(), FirstScreenView {

    init {
        setRootView(inflater.inflate(R.layout.layout_first_screen, parent, false))
    }

}
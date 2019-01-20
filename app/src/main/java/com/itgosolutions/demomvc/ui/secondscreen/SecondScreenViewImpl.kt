package com.itgosolutions.demomvc.ui.secondscreen

import android.view.LayoutInflater
import android.view.ViewGroup
import com.itgosolutions.demomvc.R
import com.itgosolutions.demomvc.ui.common.BaseViewImpl

class SecondScreenViewImpl(inflater: LayoutInflater, parent: ViewGroup?) : BaseViewImpl(), SecondScreenView {

    init {
        setRootView(inflater.inflate(R.layout.layout_second_screen, parent, false))
    }

}
package com.itgosolutions.demomvc.ui.views

import android.view.LayoutInflater
import android.view.ViewGroup
import com.itgosolutions.demomvc.ui.firstscreen.FirstScreenView
import com.itgosolutions.demomvc.ui.firstscreen.FirstScreenViewImpl
import com.itgosolutions.demomvc.ui.home.HomeView
import com.itgosolutions.demomvc.ui.home.HomeViewImpl
import com.itgosolutions.demomvc.ui.secondscreen.SecondScreenView
import com.itgosolutions.demomvc.ui.secondscreen.SecondScreenViewImpl
import com.itgosolutions.demomvc.ui.views.toolbar.ToolbarView
import com.itgosolutions.demomvc.ui.views.toolbar.ToolbarViewImpl

class ViewProviderFactory(private val layoutInflater: LayoutInflater) {

    fun newHomeView(parent: ViewGroup?, viewProviderFactory: ViewProviderFactory): HomeView {
        return HomeViewImpl(layoutInflater, parent, viewProviderFactory)
    }

    fun newToolbarView(parent: ViewGroup?): ToolbarView {
        return ToolbarViewImpl(layoutInflater, parent)
    }

    fun newFirstScreenView(parent: ViewGroup?): FirstScreenView {
        return FirstScreenViewImpl(layoutInflater, parent)
    }

    fun newSecondScreenView(parent: ViewGroup?): SecondScreenView {
        return SecondScreenViewImpl(layoutInflater, parent)
    }
}
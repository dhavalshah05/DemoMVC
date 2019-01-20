package com.itgosolutions.demomvc.ui.firstscreen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.itgosolutions.demomvc.ui.common.BaseFragment
import com.itgosolutions.demomvc.ui.common.ScreenTitleHelper
import com.itgosolutions.demomvc.ui.views.ViewProviderFactory
import javax.inject.Inject

class FirstScreenFragment : BaseFragment() {

    @Inject
    lateinit var screenTitleHelper: ScreenTitleHelper
    @Inject
    lateinit var viewProviderFactory: ViewProviderFactory

    private lateinit var firstScreenView: FirstScreenView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getControllerComponent().inject(this)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        firstScreenView = viewProviderFactory.newFirstScreenView(container)
        return firstScreenView.getRootView()
    }

    override fun onStart() {
        super.onStart()
        screenTitleHelper.setScreenTitle("Screen 1")
    }
}
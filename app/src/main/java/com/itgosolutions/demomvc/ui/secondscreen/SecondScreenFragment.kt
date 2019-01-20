package com.itgosolutions.demomvc.ui.secondscreen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.itgosolutions.demomvc.ui.common.BaseFragment
import com.itgosolutions.demomvc.ui.common.ScreenTitleHelper
import com.itgosolutions.demomvc.ui.views.ViewProviderFactory
import javax.inject.Inject

class SecondScreenFragment : BaseFragment() {

    @Inject
    lateinit var screenTitleHelper: ScreenTitleHelper
    @Inject
    lateinit var viewProviderFactory: ViewProviderFactory

    private lateinit var secondScreenView: SecondScreenView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getControllerComponent().inject(this)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        secondScreenView = viewProviderFactory.newSecondScreenView(container)
        return secondScreenView.getRootView()
    }

    override fun onStart() {
        super.onStart()
        screenTitleHelper.setScreenTitle("Screen 2")
    }
}
package com.itgosolutions.demomvc

import android.os.Bundle
import com.itgosolutions.demomvc.ui.common.BaseActivity
import com.itgosolutions.demomvc.ui.common.ScreenTitleHelper
import com.itgosolutions.demomvc.ui.compositedisposable.CompositeDisposableFragment
import com.itgosolutions.demomvc.ui.firstscreen.FirstScreenFragment
import com.itgosolutions.demomvc.ui.home.HomeView
import com.itgosolutions.demomvc.ui.secondscreen.SecondScreenFragment
import com.itgosolutions.demomvc.ui.views.ViewProviderFactory
import javax.inject.Inject

class HomeActivity : BaseActivity(), HomeView.Listener, ScreenTitleHelper {

    @Inject
    lateinit var viewProviderFactory: ViewProviderFactory

    private lateinit var homeView: HomeView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getControllerComponent().inject(this)
        homeView = viewProviderFactory.newHomeView(null, viewProviderFactory)

        setContentView(homeView.getRootView())
    }

    override fun onStart() {
        super.onStart()
        homeView.registerListener(this)
    }

    override fun onStop() {
        super.onStop()
        homeView.unregisterListener(this)
    }

    override fun onFirstScreenClicked() {
        supportFragmentManager.beginTransaction().replace(homeView.getFrameContentId(), FirstScreenFragment()).commit()
    }

    override fun onSecondScreenClicked() {
        supportFragmentManager.beginTransaction().replace(homeView.getFrameContentId(), SecondScreenFragment())
            .commit()
    }

    override fun onCompositeDisposableClicked() {
        supportFragmentManager.beginTransaction().replace(homeView.getFrameContentId(), CompositeDisposableFragment())
            .commit()
    }

    override fun setScreenTitle(title: String) {
        homeView.setScreenTitle(title)
    }

    override fun onBackPressed() {
        if (homeView.isDrawerOpen()) {
            homeView.closeDrawer()
        } else {
            super.onBackPressed()
        }
    }
}
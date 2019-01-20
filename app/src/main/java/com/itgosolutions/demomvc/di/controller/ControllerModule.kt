package com.itgosolutions.demomvc.di.controller

import android.content.Context
import android.support.v4.app.FragmentActivity
import android.support.v4.app.FragmentManager
import android.view.LayoutInflater
import com.itgosolutions.demomvc.ui.common.ScreenTitleHelper
import com.itgosolutions.demomvc.ui.views.ViewProviderFactory
import dagger.Module
import dagger.Provides

@Module
class ControllerModule(private val fragmentActivity: FragmentActivity) {

    @Provides
    fun providesContext(): Context {
        return fragmentActivity
    }

    @Provides
    fun providesFragmentActivity(): FragmentActivity {
        return fragmentActivity
    }

    @Provides
    fun providesFragmentManager(): FragmentManager {
        return fragmentActivity.supportFragmentManager
    }

    @Provides
    fun providesViewProviderFactory(context: Context): ViewProviderFactory {
        return ViewProviderFactory(LayoutInflater.from(context))
    }

    @Provides
    fun providesScreenTitleHelper(): ScreenTitleHelper {
        return fragmentActivity as ScreenTitleHelper
    }
}
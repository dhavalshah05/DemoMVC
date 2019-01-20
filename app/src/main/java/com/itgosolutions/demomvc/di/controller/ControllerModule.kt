package com.itgosolutions.demomvc.di.controller

import android.content.Context
import android.support.v4.app.FragmentManager
import android.view.LayoutInflater
import com.itgosolutions.demomvc.ui.common.BaseActivity
import com.itgosolutions.demomvc.ui.common.ScreenTitleHelper
import com.itgosolutions.demomvc.ui.views.ViewProviderFactory
import dagger.Module
import dagger.Provides

@Module
class ControllerModule(private val baseActivity: BaseActivity) {

    @Provides
    fun providesContext(): Context {
        return baseActivity
    }

    @Provides
    fun providesBaseActivity(): BaseActivity {
        return baseActivity
    }

    @Provides
    fun providesFragmentManager(): FragmentManager {
        return baseActivity.supportFragmentManager
    }

    @Provides
    fun providesViewProviderFactory(context: Context): ViewProviderFactory {
        return ViewProviderFactory(LayoutInflater.from(context))
    }

    @Provides
    fun providesScreenTitleHelper(baseActivity: BaseActivity): ScreenTitleHelper {
        return ScreenTitleHelper(baseActivity)
    }
}
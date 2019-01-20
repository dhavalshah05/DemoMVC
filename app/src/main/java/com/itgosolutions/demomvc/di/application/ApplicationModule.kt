package com.itgosolutions.demomvc.di.application

import android.app.Application
import dagger.Module
import dagger.Provides

@Module
class ApplicationModule(private val application: Application) {

    @Provides
    @ApplicationScope
    fun providesApplication(): Application {
        return application
    }

}
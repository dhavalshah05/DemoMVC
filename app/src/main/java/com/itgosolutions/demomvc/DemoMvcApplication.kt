package com.itgosolutions.demomvc

import android.app.Application
import com.itgosolutions.demomvc.di.application.ApplicationComponent
import com.itgosolutions.demomvc.di.application.ApplicationModule
import com.itgosolutions.demomvc.di.application.DaggerApplicationComponent

class DemoMvcApplication : Application() {

    private var applicationComponent: ApplicationComponent? = null

    fun getApplicationComponent(): ApplicationComponent {
        if (applicationComponent == null) {
            applicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(ApplicationModule(this))
                .build()
        }
        return applicationComponent!!
    }
}
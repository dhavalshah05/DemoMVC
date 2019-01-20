package com.itgosolutions.demomvc.ui.common

import android.support.v7.app.AppCompatActivity
import com.itgosolutions.demomvc.DemoMvcApplication
import com.itgosolutions.demomvc.di.controller.ControllerComponent
import com.itgosolutions.demomvc.di.controller.ControllerModule

abstract class BaseActivity : AppCompatActivity() {

    private var isControllerComponentUsed: Boolean = false

    protected fun getControllerComponent(): ControllerComponent {
        if (isControllerComponentUsed) {
            throw IllegalStateException("must not use controllerComponent more than once")
        }
        isControllerComponentUsed = true
        return (application as DemoMvcApplication).getApplicationComponent()
            .newControllerComponent(ControllerModule(this))
    }

}
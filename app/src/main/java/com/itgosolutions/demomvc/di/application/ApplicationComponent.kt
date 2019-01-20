package com.itgosolutions.demomvc.di.application

import com.itgosolutions.demomvc.di.controller.ControllerComponent
import com.itgosolutions.demomvc.di.controller.ControllerModule
import dagger.Component

@ApplicationScope
@Component(
    modules = [
        ApplicationModule::class
    ]
)
interface ApplicationComponent {

    fun newControllerComponent(controllerModule: ControllerModule): ControllerComponent

}
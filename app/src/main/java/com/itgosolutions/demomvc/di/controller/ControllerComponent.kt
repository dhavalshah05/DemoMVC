package com.itgosolutions.demomvc.di.controller

import com.itgosolutions.demomvc.HomeActivity
import com.itgosolutions.demomvc.ui.compositedisposable.CompositeDisposableFragment
import com.itgosolutions.demomvc.ui.firstscreen.FirstScreenFragment
import com.itgosolutions.demomvc.ui.secondscreen.SecondScreenFragment
import dagger.Subcomponent

@Subcomponent(
    modules = [
        ControllerModule::class
    ]
)
interface ControllerComponent {
    fun inject(homeActivity: HomeActivity)
    fun inject(firstScreenFragment: FirstScreenFragment)
    fun inject(secondScreenFragment: SecondScreenFragment)
    fun inject(compositeDisposableFragment: CompositeDisposableFragment)
}
package com.itgosolutions.demomvc.ui.common

import android.support.v4.app.Fragment
import com.itgosolutions.demomvc.DemoMvcApplication
import com.itgosolutions.demomvc.di.controller.ControllerComponent
import com.itgosolutions.demomvc.di.controller.ControllerModule

abstract class BaseFragment : Fragment() {

    private var isControllerComponentUsed: Boolean = false

    protected fun getControllerComponent(): ControllerComponent {
        if (isControllerComponentUsed) {
            throw IllegalStateException("must not use controllerComponent more than once")
        }
        isControllerComponentUsed = true
        return (requireActivity().application as DemoMvcApplication).getApplicationComponent()
            .newControllerComponent(ControllerModule(requireActivity() as BaseActivity))
    }

}
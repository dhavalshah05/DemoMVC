package com.itgosolutions.demomvc.ui.common

import android.content.Context
import android.view.View

abstract class BaseViewImpl : BaseView {

    private lateinit var rootView: View

    override fun getRootView(): View {
        return rootView
    }

    protected open fun setRootView(view: View) {
        rootView = view
    }

    protected fun getContext(): Context {
        return getRootView().context
    }

    protected fun <T : View> findViewById(id: Int): T {
        return getRootView().findViewById(id)
    }

}
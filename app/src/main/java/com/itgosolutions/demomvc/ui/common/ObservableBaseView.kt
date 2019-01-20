package com.itgosolutions.demomvc.ui.common

interface ObservableBaseView<ListenerClass> : BaseView {

    fun registerListener(listener: ListenerClass)

    fun unregisterListener(listener: ListenerClass)

}
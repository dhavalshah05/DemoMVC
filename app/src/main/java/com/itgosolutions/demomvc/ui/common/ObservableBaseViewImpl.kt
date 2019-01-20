package com.itgosolutions.demomvc.ui.common

import java.util.*

abstract class ObservableBaseViewImpl<ListenerClass> : BaseViewImpl(), ObservableBaseView<ListenerClass> {

    private val listeners = HashSet<ListenerClass>()

    override fun registerListener(listener: ListenerClass) {
        listeners.add(listener)
    }

    override fun unregisterListener(listener: ListenerClass) {
        listeners.remove(listener)
    }

    protected fun getListeners(): Set<ListenerClass> {
        return Collections.unmodifiableSet(listeners)
    }

}
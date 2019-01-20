package com.itgosolutions.demomvc.ui.compositedisposable

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.itgosolutions.demomvc.ui.common.BaseFragment
import com.itgosolutions.demomvc.ui.views.ViewProviderFactory
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.TimeUnit
import javax.inject.Inject

class CompositeDisposableFragment : BaseFragment(), CompositeDisposableView.Listener {

    @Inject
    lateinit var viewProviderFactory: ViewProviderFactory

    private lateinit var compositeDisposableView: CompositeDisposableView
    private val compositeDisposable = CompositeDisposable()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getControllerComponent().inject(this)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        compositeDisposableView = viewProviderFactory.newCompositeDisposableView(container)
        return compositeDisposableView.getRootView()
    }

    override fun onStart() {
        super.onStart()
        compositeDisposableView.registerListener(this)
    }

    override fun onStop() {
        super.onStop()
        compositeDisposableView.unregisterListener(this)
        compositeDisposable.clear()
    }

    override fun onStartTimerClicked() {
        compositeDisposable.add(
            getTimerObservable()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                    {
                        //println("Composite Disposable Fragment: onNext, $it")
                        compositeDisposableView.setTimerText(it.toString())
                    }, {
                        //println("Composite Disposable Fragment: Error")
                    }, {
                        //println("Composite Disposable Fragment: Complete")
                    }
                )
        )
    }

    override fun onStopTimerClicked() {
        compositeDisposableView.clearTimerText()
        compositeDisposable.clear()
    }

    private fun getTimerObservable(): Observable<Long> {
        return Observable.interval(0, 1, TimeUnit.SECONDS)
    }
}
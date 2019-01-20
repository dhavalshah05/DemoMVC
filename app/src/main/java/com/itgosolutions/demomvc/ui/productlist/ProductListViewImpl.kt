package com.itgosolutions.demomvc.ui.productlist

import android.support.constraint.ConstraintLayout
import android.support.v7.widget.AppCompatTextView
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.ProgressBar
import com.itgosolutions.demomvc.R
import com.itgosolutions.demomvc.model.Product
import com.itgosolutions.demomvc.ui.common.ObservableBaseViewImpl
import com.itgosolutions.demomvc.ui.views.notification.NotificationView
import com.itgosolutions.demomvc.ui.views.notification.NotificationViewImpl
import com.itgosolutions.demomvc.ui.views.toolbar.ToolbarView
import com.itgosolutions.demomvc.ui.views.toolbar.ToolbarViewImpl

class ProductListViewImpl(
    inflater: LayoutInflater,
    parent: ViewGroup?
) : ObservableBaseViewImpl<ProductListView.Listener>(), ProductListView, ProductListAdapter.Listener, NotificationView.Listener {

    private val recyclerViewProductList: RecyclerView
    private val textViewNoProductFound: AppCompatTextView
    private val progressProductList: ProgressBar

    private val notificationView: NotificationView
    private val toolbarView: ToolbarView
    private lateinit var productListAdapter: ProductListAdapter

    init {
        setRootView(inflater.inflate(R.layout.layout_product_list, parent, false))
        notificationView = NotificationViewImpl(inflater, parent)
        notificationView.registerListener(this)

        recyclerViewProductList = findViewById(R.id.recyclerViewProductList)
        textViewNoProductFound = findViewById(R.id.textViewNoProductsFound)
        progressProductList = findViewById(R.id.progressProductList)

        // init toolbar
        val containerToolbar: FrameLayout = findViewById(R.id.containerToolbar)
        toolbarView = ToolbarViewImpl(inflater, containerToolbar)
        toolbarView.setTitle("Product List")
        toolbarView.setBackgroundColor(R.color.colorAccent)
        containerToolbar.addView(toolbarView.getRootView())

        initProductListRecyclerView()
    }

    override fun showLoading() {
        progressProductList.visibility = View.VISIBLE
    }

    override fun hideLoading() {
        progressProductList.visibility = View.GONE
    }

    override fun showNoProductsFoundMessage() {
        textViewNoProductFound.visibility = View.VISIBLE
    }

    override fun hideNoProductsFoundMessage() {
        textViewNoProductFound.visibility = View.GONE
    }

    override fun showProducts() {
        progressProductList.visibility = View.VISIBLE
    }

    override fun hideProducts() {
        progressProductList.visibility = View.GONE
    }

    override fun bindProducts(products: List<Product>) {
        productListAdapter.bindProducts(products)
    }

    override fun showNotification(title: String) {
        findViewById<ConstraintLayout>(R.id.layoutMain).removeView(notificationView.getRootView())
        findViewById<ConstraintLayout>(R.id.layoutMain).addView(notificationView.getRootView())
        notificationView.bindTitle(title)
        notificationView.animate()
    }

    override fun hideNotification() {
        findViewById<ConstraintLayout>(R.id.layoutMain).removeView(notificationView.getRootView())
    }

    override fun onProductClicked(product: Product) {
        getListeners().forEach { listener -> listener.onProductClicked(product) }
    }

    override fun onCloseNotificationClicked() {
        getListeners().forEach { listener -> listener.onCloseNotificationClicked() }
    }


    private fun initProductListRecyclerView() {
        recyclerViewProductList.layoutManager = LinearLayoutManager(getContext())
        recyclerViewProductList.setHasFixedSize(true)

        productListAdapter = ProductListAdapter(this)
        recyclerViewProductList.adapter = productListAdapter
    }
}
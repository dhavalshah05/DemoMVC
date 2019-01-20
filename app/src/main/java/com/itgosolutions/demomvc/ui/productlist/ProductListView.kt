package com.itgosolutions.demomvc.ui.productlist

import com.itgosolutions.demomvc.model.Product
import com.itgosolutions.demomvc.ui.common.ObservableBaseView

interface ProductListView : ObservableBaseView<ProductListView.Listener> {

    interface Listener {
        fun onProductClicked(product: Product)
        fun onCloseNotificationClicked()
    }

    fun showLoading()
    fun hideLoading()

    fun showNoProductsFoundMessage()
    fun hideNoProductsFoundMessage()

    fun showProducts()
    fun hideProducts()
    fun bindProducts(products: List<Product>)

    fun showNotification(title: String)
    fun hideNotification()
}
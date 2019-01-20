package com.itgosolutions.demomvc.ui.productlist

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.itgosolutions.demomvc.model.Product

class ProductListFragment : Fragment(), ProductListView.Listener {

    private lateinit var productListView: ProductListView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        productListView = ProductListViewImpl(inflater, container)
        return productListView.getRootView()
    }

    override fun onStart() {
        super.onStart()
        productListView.registerListener(this)

        productListView.bindProducts(getDummyProducts())
    }

    override fun onStop() {
        super.onStop()
        productListView.unregisterListener(this)
    }

    override fun onProductClicked(product: Product) {
        productListView.showNotification(product.name)
    }

    override fun onCloseNotificationClicked() {
        productListView.hideNotification()
    }

    private fun getDummyProducts(): List<Product> {
        val products = mutableListOf<Product>()

        products.add(Product(1, "iPhone 7"))
        products.add(Product(2, "Apple Macbook Air"))
        products.add(Product(3, "Samsung Galaxy Note 9"))
        products.add(Product(4, "Android TV"))
        products.add(Product(5, "Xiomi Smart Watch"))
        products.add(Product(6, "iphon5"))

        return products
    }
}
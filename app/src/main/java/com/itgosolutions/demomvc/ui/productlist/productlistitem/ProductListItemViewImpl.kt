package com.itgosolutions.demomvc.ui.productlist.productlistitem

import android.support.v7.widget.AppCompatTextView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.itgosolutions.demomvc.R
import com.itgosolutions.demomvc.model.Product
import com.itgosolutions.demomvc.ui.common.ObservableBaseViewImpl

class ProductListItemViewImpl(
    inflater: LayoutInflater,
    parent: ViewGroup?
) : ObservableBaseViewImpl<ProductListItemView.Listener>(), ProductListItemView {

    private val textViewProductId: AppCompatTextView
    private val textViewProductName: AppCompatTextView

    private var product: Product? = null

    init {
        setRootView(inflater.inflate(R.layout.row_product, parent, false))

        textViewProductId = findViewById(R.id.textViewProductId)
        textViewProductName = findViewById(R.id.textViewProductName)

        // Set click listener
        getRootView().setOnClickListener { _ ->
            getListeners().forEach { listener ->
                product?.let { listener.onProductRowClicked(it) }
            }
        }
    }

    override fun bindProduct(product: Product) {
        this.product = product

        textViewProductId.text = product.id.toString()
        textViewProductName.text = product.name
    }
}
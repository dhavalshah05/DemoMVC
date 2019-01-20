package com.itgosolutions.demomvc.ui.productlist.productlistitem

import com.itgosolutions.demomvc.model.Product
import com.itgosolutions.demomvc.ui.common.ObservableBaseView

interface ProductListItemView : ObservableBaseView<ProductListItemView.Listener> {

    interface Listener {
        fun onProductRowClicked(product: Product)
    }

    fun bindProduct(product: Product)
}
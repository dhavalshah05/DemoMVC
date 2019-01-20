package com.itgosolutions.demomvc.ui.productlist

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.itgosolutions.demomvc.model.Product
import com.itgosolutions.demomvc.ui.productlist.productlistitem.ProductListItemView
import com.itgosolutions.demomvc.ui.productlist.productlistitem.ProductListItemViewImpl

class ProductListAdapter(private val listener: Listener) : RecyclerView.Adapter<ProductListAdapter.ProductViewHolder>(), ProductListItemView.Listener {

    interface Listener {
        fun onProductClicked(product: Product)

    }

    private val products = mutableListOf<Product>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val productRowView = ProductListItemViewImpl(LayoutInflater.from(parent.context), parent)
        productRowView.registerListener(this)
        return ProductViewHolder(productRowView)
    }

    override fun getItemCount(): Int {
        return products.size
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val product = products[position]
        holder.productListItemView.bindProduct(product)
    }

    override fun onProductRowClicked(product: Product) {
        listener.onProductClicked(product)
    }

    fun bindProducts(products: List<Product>) {
        this.products.clear()
        this.products.addAll(products)
        notifyDataSetChanged()
    }

    inner class ProductViewHolder(val productListItemView: ProductListItemView) : RecyclerView.ViewHolder(
        productListItemView.getRootView()
    )

}
package com.itgosolutions.demomvc.ui.views.toolbar

import android.support.v4.content.ContextCompat
import android.support.v7.widget.Toolbar
import android.view.LayoutInflater
import android.view.ViewGroup
import com.itgosolutions.demomvc.R
import com.itgosolutions.demomvc.ui.common.BaseViewImpl

class ToolbarViewImpl(inflater: LayoutInflater, parent: ViewGroup?) :
        BaseViewImpl(),
        ToolbarView {

    private var toolbar: Toolbar
    private var navigateBackPressedListener: ToolbarView.NavigateBackPressedListener? = null
    private var hamburgerMenuClickedListener: ToolbarView.HamburgerMenuClickedListener? = null

    init {
        setRootView(inflater.inflate(R.layout.layout_toolbar_main, parent, false))

        // init toolbar
        toolbar = findViewById(R.id.toolbarMain)
    }

    override fun setTitle(title: String) {
        toolbar.title = title
    }

    override fun setTitle(id: Int) {
        toolbar.title = getContext().resources.getString(id)
    }

    override fun setBackgroundColor(id: Int) {
        toolbar.setBackgroundColor(ContextCompat.getColor(getContext(), id))
    }

    override fun enableBackButtonAndListen(listener: ToolbarView.NavigateBackPressedListener) {
        navigateBackPressedListener = listener
        toolbar.setNavigationIcon(R.drawable.ic_back_white)
        toolbar.setNavigationOnClickListener { navigateBackPressedListener?.onNavigateBackPressed() }
    }

    override fun disableBackButton() {
        toolbar.navigationIcon = null
        navigateBackPressedListener = null
    }

    override fun enableHamburgerMenuAndListen(listener: ToolbarView.HamburgerMenuClickedListener) {
        hamburgerMenuClickedListener = listener
        toolbar.setNavigationIcon(R.drawable.ic_menu_white)
        toolbar.setNavigationOnClickListener { hamburgerMenuClickedListener?.onHamburgerMenuClicked() }
    }

    override fun disableHamburgerMenu() {
        toolbar.navigationIcon = null
        hamburgerMenuClickedListener = null
    }
}
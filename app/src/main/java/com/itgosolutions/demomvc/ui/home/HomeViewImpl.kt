package com.itgosolutions.demomvc.ui.home

import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v4.widget.DrawerLayout
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.ViewGroup
import android.widget.FrameLayout
import com.itgosolutions.demomvc.R
import com.itgosolutions.demomvc.ui.common.ObservableBaseViewImpl
import com.itgosolutions.demomvc.ui.views.ViewProviderFactory
import com.itgosolutions.demomvc.ui.views.toolbar.ToolbarView

class HomeViewImpl(
    inflater: LayoutInflater,
    parent: ViewGroup?,
    viewProviderFactory: ViewProviderFactory
) : ObservableBaseViewImpl<HomeView.Listener>(), HomeView {

    private val drawerLayout: DrawerLayout
    private val navigationView: NavigationView
    private val toolbarView: ToolbarView

    init {
        setRootView(inflater.inflate(R.layout.layout_drawer, parent, false))

        drawerLayout = findViewById(R.id.drawerLayout)
        navigationView = findViewById(R.id.navigationView)

        // Init toolbar
        val containerToolbar: FrameLayout = findViewById(R.id.containerToolbar)
        toolbarView = viewProviderFactory.newToolbarView(containerToolbar)
        toolbarView.setTitle("Demo MVC")
        toolbarView.setBackgroundColor(R.color.colorAccent)
        toolbarView.enableHamburgerMenuAndListen(object : ToolbarView.HamburgerMenuClickedListener {
            override fun onHamburgerMenuClicked() {
                drawerLayout.openDrawer(GravityCompat.START)
            }
        })
        containerToolbar.addView(toolbarView.getRootView())

        navigationView.setNavigationItemSelectedListener { item: MenuItem ->
            drawerLayout.closeDrawers()

            if (item.itemId == R.id.drawerMenuItemFirstScreen) {
                onDrawerItemClicked(DrawerItem.FIRST_SCREEN)
            } else if (item.itemId == R.id.drawerMenuItemSecondScreen) {
                onDrawerItemClicked(DrawerItem.SECOND_SCREEN)
            }

            false
        }
    }

    private fun onDrawerItemClicked(drawerItem: DrawerItem) {
        when (drawerItem) {
            DrawerItem.FIRST_SCREEN -> {
                getListeners().forEach { listener -> listener.onFirstScreenClicked() }
            }
            DrawerItem.SECOND_SCREEN -> {
                getListeners().forEach { listener -> listener.onSecondScreenClicked() }
            }
        }
    }

    override fun getFrameContentId(): Int {
        return R.id.contentFrame
    }

    override fun setScreenTitle(title: String) {
        toolbarView.setTitle(title)
    }

    override fun isDrawerOpen(): Boolean {
        return drawerLayout.isDrawerOpen(GravityCompat.START)
    }

    override fun closeDrawer() {
        drawerLayout.closeDrawers()
    }
}
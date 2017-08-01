package com.newgate.rxjava.activity

import android.view.Gravity
import com.newgate.rxjava.fragment.MenuFragment
import com.newgate.rxjava.R
import com.newgate.rxjava.fragment.RxJavaFunFragment
import com.newgate.rxjava.base.BaseActivity
import com.newgate.rxjava.base.NavigationManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {

    override fun layoutResID(): Int {
        return R.layout.activity_main
    }

    override fun bindView() {
        navigation.openFragment(R.id.menuFrame, MenuFragment.newInstance(), NavigationManager.Type.ADD)
        navigation.openFragment(R.id.containerFrame, RxJavaFunFragment.newInstance(), NavigationManager.Type.ADD, NavigationManager.AnimationType.LEFT_RIGHT)
    }

    fun closeDrawLayout() {
        drawerLayout.closeDrawer(Gravity.LEFT)
    }

    fun openDrawLayout() {
        drawerLayout.openDrawer(Gravity.LEFT)
    }
}

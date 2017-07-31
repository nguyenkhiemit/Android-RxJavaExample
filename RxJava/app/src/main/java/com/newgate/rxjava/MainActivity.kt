package com.newgate.rxjava

import com.newgate.rxjava.base.BaseActivity
import com.newgate.rxjava.base.NavigationManager

class MainActivity : BaseActivity() {

    override fun layoutResID(): Int {
        return R.layout.activity_main
    }

    override fun bindView() {
        navigation.openFragment(R.id.menuFrame, MenuFragment.newInstance(), NavigationManager.Type.ADD)
        navigation.openFragment(R.id.containerFrame, RxJavaFunFragment.newInstance(), NavigationManager.Type.ADD, NavigationManager.AnimationType.LEFT_RIGHT)
    }
}

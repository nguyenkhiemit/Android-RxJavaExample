package com.newgate.rxjava.fragment

import android.view.View
import com.newgate.rxjava.R
import com.newgate.rxjava.base.BaseFragment
import com.newgate.rxjava.base.NavigationManager
import kotlinx.android.synthetic.main.fragment_test_b.view.*

/**
 * Created by apple on 8/28/17.
 */
class TestNavigationB: BaseFragment() {

    override fun layoutResID(): Int {
        return R.layout.fragment_test_b
    }

    companion object {
        fun newInstance(): TestNavigationB {
            var instance = TestNavigationB()
            return instance
        }
    }

    override fun bindView(view: View) {
        view.nextText.setOnClickListener {
            navigation.openFragment(R.id.containerFrame, TestNavigationC.newInstance(), NavigationManager.Type.REPLACE, NavigationManager.AnimationType.LEFT_RIGHT)
        }
    }
}
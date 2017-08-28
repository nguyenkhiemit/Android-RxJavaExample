package com.newgate.rxjava.fragment

import android.view.View
import com.newgate.rxjava.R
import com.newgate.rxjava.base.BaseFragment
import com.newgate.rxjava.base.NavigationManager
import kotlinx.android.synthetic.main.fragment_test_a.view.*

/**
 * Created by apple on 8/28/17.
 */
class TestNavigationA: BaseFragment() {

    override fun layoutResID(): Int {
        return R.layout.fragment_test_a
    }

    companion object {
        fun newInstance(): TestNavigationA {
            var instance = TestNavigationA()
            return instance
        }
    }

    override fun bindView(view: View) {
        view.nextText.setOnClickListener {
            navigation.openFragment(R.id.containerFrame, TestNavigationB.newInstance(), NavigationManager.Type.REPLACE, NavigationManager.AnimationType.LEFT_RIGHT)
        }
    }
}
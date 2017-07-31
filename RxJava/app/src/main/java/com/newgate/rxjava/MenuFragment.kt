package com.newgate.rxjava

import android.view.View
import com.newgate.rxjava.base.BaseFragment

/**
 * Created by apple on 7/31/17.
 */
class MenuFragment: BaseFragment() {

    override fun layoutResID(): Int {
        return R.layout.fragment_menu
    }

    companion object {
        fun newInstance(): MenuFragment {
            var instance = MenuFragment()
            return instance
        }
    }

    override fun bindView(view: View) {

    }
}


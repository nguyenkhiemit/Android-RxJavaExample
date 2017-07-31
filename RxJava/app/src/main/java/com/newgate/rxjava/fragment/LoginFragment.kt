package com.newgate.rxjava.fragment

import android.view.View
import com.newgate.rxjava.R
import com.newgate.rxjava.base.BaseFragment

/**
 * Created by khiemnd on 7/31/17.
 */
class LoginFragment: BaseFragment() {

    companion object {
        fun newInstance(): LoginFragment {
            var instance = LoginFragment()
            return instance
        }
    }

    override fun layoutResID(): Int {
        return R.layout.fragment_login
    }

    override fun bindView(view: View) {

    }
}
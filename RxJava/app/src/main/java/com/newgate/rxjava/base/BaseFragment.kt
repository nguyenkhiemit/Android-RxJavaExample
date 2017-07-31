package com.newgate.rxjava.base

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.newgate.rxjava.activity.MainActivity

/**
 * Created by apple on 7/31/17.
 */
open abstract class BaseFragment: Fragment() {

    abstract fun layoutResID(): Int

    abstract fun bindView(view: View)

    lateinit var navigation: NavigationManager

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var view = inflater!!.inflate(layoutResID(), container, false)
        navigation = NavigationManager(activity)
        bindView(view)
        return view
    }
 
}
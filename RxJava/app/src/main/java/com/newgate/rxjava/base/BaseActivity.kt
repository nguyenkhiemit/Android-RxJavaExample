package com.newgate.rxjava.base

import android.os.Bundle
import android.os.PersistableBundle
import android.support.v4.app.FragmentActivity
import android.support.v7.app.AppCompatActivity

/**
 * Created by apple on 7/31/17.
 */
open abstract class BaseActivity: FragmentActivity() {

    abstract fun layoutResID(): Int

    abstract fun bindView()

    lateinit var navigation: NavigationManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layoutResID())
        navigation = NavigationManager(this)
        bindView()
    }
}
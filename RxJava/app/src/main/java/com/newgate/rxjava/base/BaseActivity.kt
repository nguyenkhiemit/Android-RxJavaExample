package com.newgate.rxjava.base

import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.newgate.rxjava.utils.DialogUtils

/**
 * Created by apple on 7/31/17.
 */
open abstract class BaseActivity: AppCompatActivity() {

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
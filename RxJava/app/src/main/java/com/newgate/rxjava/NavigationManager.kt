package com.newgate.rxjava

import android.app.Activity
import android.support.annotation.IdRes
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentTransaction
import android.support.v7.app.AppCompatActivity
import java.util.*
import javax.xml.datatype.Duration

/**
 * Created by khiemnd on 7/30/17.
 */
class NavigationManager(var activity: AppCompatActivity) {

    var fragmentManager = activity.supportFragmentManager

    var preTime: Long = 0

    enum class Type {
        ADD, REPLACE
    }

    enum class AnimationType(var duration: Long) {
        LEFT_RIGHT(200), BOTTOM_TOP(400)
    }

    fun openFragment(@IdRes containerId: Int, fragment: Fragment, type: Type, animType: AnimationType) {
        var currTime = Date().time
        if(currTime - preTime <= animType.duration) {
            preTime = currTime
        } else {
            return
        }
        var transaction: FragmentTransaction = fragmentManager.beginTransaction()
        when(type) {
            Type.ADD -> transaction.add(containerId, fragment)
            Type.REPLACE -> transaction.replace(containerId, fragment)
        }
        when(animType) {
            AnimationType.LEFT_RIGHT -> transaction.setCustomAnimations(R.anim.slide_enter_left, R.anim.slide_exit_left)
            AnimationType.BOTTOM_TOP -> transaction.setCustomAnimations(R.anim.slide_enter_bottom, R.anim.slide_exit_bottom)
        }
        transaction.addToBackStack(fragment.javaClass.simpleName)
        transaction.commit()
    }

    fun closeFragment() {
        if (backStackCount() > 0) {
            fragmentManager.popBackStack()
        }
    }

    fun gotoFragment(tag: String) {
        while (backStackCount() > 0) {
            if(fragmentManager.getBackStackEntryAt(0).equals(tag)) {
                break
            }
            fragmentManager.popBackStack()
        }
    }

    fun findFragment(tag: String): Fragment {
        return fragmentManager.findFragmentByTag(tag)
    }

    fun backStackCount(): Int {
        return fragmentManager.backStackEntryCount
    }
    
}
package com.newgate.rxjava.fragment

import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.widget.RelativeLayout
import com.newgate.rxjava.R
import com.newgate.rxjava.RxJavaFunFragment
import com.newgate.rxjava.adapter.MenuAdapter
import com.newgate.rxjava.base.BaseFragment
import com.newgate.rxjava.base.NavigationManager
import com.newgate.rxjava.models.Menu
import junit.framework.Test
import kotlinx.android.synthetic.main.fragment_menu.view.*

/**
 * Created by apple on 7/31/17.
 */
class MenuFragment: BaseFragment() {

    lateinit var arrayMenu: ArrayList<Menu>

    lateinit var adapter: MenuAdapter

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
        arrayMenu = ArrayList<Menu>()
        var menus = context.resources.getStringArray(R.array.menu_array)
        for(i in menus.indices) {
            arrayMenu.add(Menu(i, menus[i]))
        }
        adapter = MenuAdapter(context, arrayMenu) {
            navigation.backToRoot()
            when(it) {
                0 -> navigation.openFragment(R.id.containerFrame, RxJavaFunFragment.newInstance(), NavigationManager.Type.REPLACE, NavigationManager.AnimationType.LEFT_RIGHT)
                1 -> navigation.openFragment(R.id.containerFrame, LoginFragment.newInstance(), NavigationManager.Type.REPLACE, NavigationManager.AnimationType.LEFT_RIGHT)
                3 -> navigation.openFragment(R.id.containerFrame, TestNavigationA.newInstance(), NavigationManager.Type.REPLACE, NavigationManager.AnimationType.LEFT_RIGHT)
            }
            getMainActivity()?.closeDrawLayout()
        }
        view.menuRecyclerView.layoutManager = LinearLayoutManager(context)
        view.menuRecyclerView.adapter = adapter
    }
}


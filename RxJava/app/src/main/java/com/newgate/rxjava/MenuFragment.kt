package com.newgate.rxjava

import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.newgate.rxjava.base.BaseFragment
import com.newgate.rxjava.models.Menu
import kotlinx.android.synthetic.main.fragment_menu.view.*

/**
 * Created by apple on 7/31/17.
 */
class MenuFragment: BaseFragment() {

    lateinit var arrayMenu: ArrayList<Menu>

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
        view.menuRecyclerView.layoutManager = LinearLayoutManager(context)
        view.menuRecyclerView.
    }
}


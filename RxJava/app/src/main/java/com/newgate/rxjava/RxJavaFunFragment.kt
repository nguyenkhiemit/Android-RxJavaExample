package com.newgate.rxjava

import android.util.Log
import android.view.View
import com.jakewharton.rxbinding.view.RxView
import com.jakewharton.rxbinding.widget.RxTextView
import com.newgate.rxjava.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_rxjava.view.*
import rx.Observable

/**
 * Created by apple on 7/31/17.
 */
class RxJavaFunFragment: BaseFragment() {

    override fun layoutResID(): Int {
        return R.layout.fragment_rxjava
    }

    companion object {
        fun newInstance(): RxJavaFunFragment {
            var instance = RxJavaFunFragment()
            return instance
        }
    }

    override fun bindView(view: View) {
        RxView.clicks(view.filterButton).subscribe {
            Observable.just(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
                    .filter { i -> i % 2 == 0 }
                    .subscribe {
                        Log.e("RxJava ", "" + it)
                    }
        }

        RxView.clicks(view.forEachButton).subscribe {
            Observable.just(1, 2, 3, 4, 5)
                    .forEach {
                        Log.e("RxJava ", "" + it)
                    }
        }

        RxView.clicks(view.groupByButton).subscribe {
            Observable.just(1, 2, 3, 4, 5)
                    .groupBy<Any> { integer -> integer!! % 2 == 0 }
                    .subscribe { grouped -> grouped.toList().
                            subscribe {
                                integers -> print(integers + " (Even: " + grouped.key + ")")
                            }
                    }

        }

        RxView.clicks(view.takeButton).subscribe {
            Observable.just(1, 2, 3, 4, 5)
                    .take(3)
                    .subscribe {
                        Log.e("RxJava ", "" + it)
                    }
        }

        RxView.clicks(view.firstButton).subscribe {
            Observable.just(1, 2, 3, 4, 5)
                    .first()
                    .subscribe {
                        Log.e("RxJava ", "" + it)
                    }
        }

        RxView.clicks(view.lastButton).subscribe {
            Observable.just(1, 2, 3, 4, 5)
                    .last()
                    .subscribe {
                        Log.e("RxJava ", "" + it)
                    }
        }

        RxView.clicks(view.distinctButton).subscribe {
            Observable.just(1, 2, 3, 4, 3, 5, 2)
                    .distinct()
                    .subscribe {
                        Log.e("RxJava ", "" + it)
                    }
        }

        RxView.clicks(view.mapButton).subscribe {
            Observable.just(1, 2, 3)
                    .map { i -> i * 2 }
                    .subscribe {
                        Log.e("RxJava ", "" + it)
                    }
        }

        RxView.clicks(view.iterateButton).subscribe {
            var users = ArrayList<User>()
            users.add(User("John Snow"))
            users.add(User("Tyrion Lannister"))

            Observable.just(users)
                    .concatMap {
                        list -> Observable.from(list)
                    }
                    .subscribe {
                        Log.e("RxJava ", "" + it.name)
                    }
        }

        RxTextView.textChangeEvents(view.observeEditText).subscribe {
            Log.e("RxJava ", "" + it.text())
        }


    }


}
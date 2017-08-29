package com.newgate.rxjava

import android.util.Log
import android.view.View
import com.jakewharton.rxbinding.view.RxView
import com.jakewharton.rxbinding.widget.RxTextView
import com.newgate.rxjava.base.BaseFragment
import com.newgate.rxjava.models.User
import kotlinx.android.synthetic.main.fragment_rxjava.view.*
import rx.Observable
import java.util.*
import java.util.concurrent.TimeUnit

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
        /**
         * filter
         */
        RxView.clicks(view.filterButton).subscribe {
            Observable.just(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
                    .filter { i -> i % 2 == 0 }
                    .subscribe {
                        Log.e("RxJava ", "" + it)
                    }
        }

        /**
         * for each
         */
        RxView.clicks(view.forEachButton).subscribe {
            Observable.just(1, 2, 3, 4, 5)
                    .forEach {
                        Log.e("RxJava ", "" + it)
                    }
        }

        /**
         * group by
         */
        RxView.clicks(view.groupByButton).subscribe {
            Observable.just(1, 2, 3, 4, 5)
                    .groupBy<Any> { integer -> integer!! % 2 == 0 }
                    .subscribe { grouped -> grouped.toList().
                            subscribe {
                                integers -> print(integers + " (Even: " + grouped.key + ")")
                            }
                    }

        }

        /**
         * take
         */
        RxView.clicks(view.takeButton).subscribe {
            Observable.just(1, 2, 3, 4, 5)
                    .take(3)
                    .subscribe {
                        Log.e("RxJava ", "" + it)
                    }
        }

        /**
         * first
         */
        RxView.clicks(view.firstButton).subscribe {
            Observable.just(1, 2, 3, 4, 5)
                    .first()
                    .subscribe {
                        Log.e("RxJava ", "" + it)
                    }
        }

        /**
         * last
         */
        RxView.clicks(view.lastButton).subscribe {
            Observable.just(1, 2, 3, 4, 5)
                    .last()
                    .subscribe {
                        Log.e("RxJava ", "" + it)
                    }
        }

        /**
         * distinct
         */
        RxView.clicks(view.distinctButton).subscribe {
            Observable.just(1, 2, 3, 4, 3, 5, 2)
                    .distinct()
                    .subscribe {
                        Log.e("RxJava ", "" + it)
                    }
        }

        /**
         * map
         */
        RxView.clicks(view.mapButton).subscribe {
            Observable.just(1, 2, 3)
                    .map { i -> i * 2 }
                    .subscribe {
                        Log.e("RxJava ", "" + it)
                    }
        }

        /**
         * iterate
         */
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

        /**
         * Flat Map
         * input: [a, b, c]
         * output : [ax, bx, cx]
         */
        RxView.clicks(view.flatMap).subscribe {
            var items = arrayListOf<String>()
            items.add("a")
            items.add("b")
            items.add("c")
            Observable.from(items).flatMap {
                Observable.just(it + "x")
            }.toList().subscribe {
                Log.e("RxJava ", "" + it)
            }
        }

        /**
         * Flat Map
         * input: a, b, c / x, y, z
         * output : [a, b, c, x, y, z]
         */
        RxView.clicks(view.flatMap2).subscribe {
            val sequence1 = Observable.just("x", "y", "z")
            val sequence2 = Observable.just("a", "b", "c")
            val sequenceOfSequences = Observable.just(sequence1, sequence2)
            sequenceOfSequences.flatMap { it }.toList().subscribe {
                Log.e("RxJava ", "" + it)
            }
        }

    }


}

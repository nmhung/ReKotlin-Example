package com.fitken.rekotlinexample.ui

import android.content.Context
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import com.fitken.rekotlinexample.ui.explore.ExploreFragment
import com.fitken.rekotlinexample.ui.viewed.ViewedFragment

/**
 * Created by ken on 3/23/18.
 */
class MainViewPagerAdapter(context: Context, fragmentManager: FragmentManager) : FragmentPagerAdapter(fragmentManager) {

    private var mFragments: ArrayList<Fragment> = ArrayList()

    init {
        mFragments.add(ExploreFragment.newInstance(context))
        mFragments.add(ViewedFragment.newInstance(context))
    }

    override fun getItem(position: Int): Fragment {
        return mFragments[position]
    }

    override fun getCount(): Int {
        return mFragments.size
    }
}
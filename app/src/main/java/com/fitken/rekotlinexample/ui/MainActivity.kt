package com.fitken.rekotlinexample.ui

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.fitken.rekotlinexample.R
import com.fitken.rekotlinexample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var mBinding: ActivityMainBinding
    private lateinit var mViewPagerAdapter: MainViewPagerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        setUpViewPager()
    }

    private fun setUpViewPager() {
        mViewPagerAdapter = MainViewPagerAdapter(this, supportFragmentManager)
        mBinding.vpContent.adapter = mViewPagerAdapter
        mBinding.bnvNavigation.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.action_list_item -> mBinding.vpContent.setCurrentItem(0, true)
                R.id.action_viewed -> mBinding.vpContent.setCurrentItem(1, true)
            }
            true
        }
    }
}

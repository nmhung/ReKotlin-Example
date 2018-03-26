package com.fitken.rekotlinexample.viewed

import android.content.Context
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.fitken.rekotlinexample.R
import com.fitken.rekotlinexample.databinding.FragmentViewedBinding
import com.fitken.rekotlinexample.explore.ExploreAdapter
import com.fitken.rekotlinexample.explore.ShopItem
import com.fitken.rekotlinexample.states.ViewedListState
import com.fitken.rekotlinexample.store
import tw.geothings.rekotlin.StoreSubscriber

/**
 * Created by ken on 3/23/18.
 */
class ViewedFragment : Fragment(), StoreSubscriber<ViewedListState?>, ExploreAdapter.OnItemClickListener {

    private lateinit var mAdapter: ExploreAdapter
    private lateinit var mBinding: FragmentViewedBinding

    companion object {
        fun newInstance(context: Context): ViewedFragment {
            return Fragment.instantiate(context, ViewedFragment::class.java.name, null) as ViewedFragment
        }
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_viewed, container, false)
        return mBinding.root
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpRecyclerView()
    }

    override fun onStart() {
        super.onStart()
        store.subscribe(this) {
            it.select {
                it.viewedListState
            }
        }
    }

    override fun onStop() {
        super.onStop()
        store.unsubscribe(this)
    }

    private fun setUpRecyclerView() {
        mAdapter = ExploreAdapter(this)
        mBinding.rvViewed.adapter = mAdapter
    }

    override fun newState(state: ViewedListState?) {
        Log.e("newState\\n", "state: ${state?.shopItems}")
        if (state != null) {
            mAdapter.update(state.shopItems)
        }
    }

    override fun onClick(shopItem: ShopItem) {

    }
}
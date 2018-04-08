package com.fitken.rekotlinexample.ui.explore

import android.content.Context
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.fitken.rekotlinexample.R
import com.fitken.rekotlinexample.actions.ActionUpdateShopItemList
import com.fitken.rekotlinexample.databinding.FragmentExploreBinding
import com.fitken.rekotlinexample.ui.shopitemdetails.ShopItemDetailsActivity
import com.fitken.rekotlinexample.states.ShopItemListState
import com.fitken.rekotlinexample.store
import tw.geothings.rekotlin.StoreSubscriber

/**
 * Created by ken on 3/23/18.
 */


class ExploreFragment : Fragment(), ExploreAdapter.OnItemClickListener, StoreSubscriber<ShopItemListState?> {

    private lateinit var mAdapter: ExploreAdapter
    private lateinit var mBinding: FragmentExploreBinding

    companion object {
        fun newInstance(context: Context): ExploreFragment {
            return ExploreFragment::class.java.cast(Fragment.instantiate(context, ExploreFragment::class.java.name, null))
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_explore, container, false)
        return mBinding.root
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpRecyclerView()
        loadData()
    }

    override fun onStart() {
        super.onStart()
        store.subscribe(this) {
            it.select {
                it.shopItemListState
            }
        }
    }

    override fun onStop() {
        super.onStop()
        store.unsubscribe(this)
    }

    private fun setUpRecyclerView() {
        mAdapter = ExploreAdapter(this)
        mBinding.rvExplore.adapter = mAdapter
    }

    private fun loadData() {
        var shopItems = ArrayList<ShopItem>()
        for (i in 0 until 10) {
            val comments = ArrayList<Comment>()
            val shopItem = ShopItem(i, "Item $i", false, comments, "0")
            shopItems.add(shopItem)
        }
        store.dispatch(ActionUpdateShopItemList(shopItems))
    }

    override fun onClick(shopItem: ShopItem) {
        ShopItemDetailsActivity.start(activity, shopItem)
    }

    override fun newState(state: ShopItemListState?) {
        Log.e("newState", "state: ${state?.shopItems.toString()}")
        if (state?.shopItems != null) {
            mAdapter.update(state.shopItems)
        }
    }
}
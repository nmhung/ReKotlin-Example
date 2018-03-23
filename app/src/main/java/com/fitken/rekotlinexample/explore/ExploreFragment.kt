package com.fitken.rekotlinexample.explore

import android.content.Context
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.fitken.rekotlinexample.R
import com.fitken.rekotlinexample.ShopItemManager
import com.fitken.rekotlinexample.databinding.FragmentExploreBinding
import com.fitken.rekotlinexample.shopitemdetails.ShopItemDetailsActivity

/**
 * Created by ken on 3/23/18.
 */
class ExploreFragment : Fragment(), ExploreAdapter.OnItemClickListener {
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

    override fun onResume() {
        super.onResume()
        mAdapter.notifyDataSetChanged()
    }

    private fun setUpRecyclerView() {
        mAdapter = ExploreAdapter(this)
        mBinding.rvExplore.adapter = mAdapter
    }

    private fun loadData() {
        mAdapter.update(ShopItemManager.instance.getListShopItem())
    }

    override fun onClick(shopItem: ShopItem) {
        ShopItemDetailsActivity.start(activity, shopItem)
    }
}
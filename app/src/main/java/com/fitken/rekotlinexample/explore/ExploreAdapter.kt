package com.fitken.rekotlinexample.explore

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.fitken.rekotlinexample.databinding.ItemShopItemBinding

/**
 * Created by ken on 3/23/18.
 */
class ExploreAdapter(onItemClickListener: OnItemClickListener) : RecyclerView.Adapter<ExploreAdapter.ExploreViewHolder>() {
    private var mShopItems = ArrayList<ShopItem>()
    private var mListener = onItemClickListener

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ExploreViewHolder {
        return ExploreViewHolder(ItemShopItemBinding.inflate(LayoutInflater.from(parent?.context),
                parent, false), mListener)
    }

    override fun getItemCount() =
            mShopItems.size


    override fun onBindViewHolder(holder: ExploreViewHolder?, position: Int) {
        holder?.bindData(mShopItems[position])
    }

    fun update(shopItems: ArrayList<ShopItem>) {
        mShopItems = shopItems
        notifyDataSetChanged()
    }

    class ExploreViewHolder(private val itemShopItemBinding: ItemShopItemBinding,
                            private val onItemClickListener: OnItemClickListener) : RecyclerView.ViewHolder(itemShopItemBinding.root) {


        fun bindData(shopItem: ShopItem) {
            itemShopItemBinding.shopItem = shopItem
            itemShopItemBinding.root.setOnClickListener({
                onItemClickListener.onClick(shopItem)
            })
        }
    }

    interface OnItemClickListener {
        fun onClick(shopItem: ShopItem)
    }
}
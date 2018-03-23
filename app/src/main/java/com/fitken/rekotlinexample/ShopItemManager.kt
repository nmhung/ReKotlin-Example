package com.fitken.rekotlinexample

import com.fitken.rekotlinexample.explore.Comment
import com.fitken.rekotlinexample.explore.ShopItem

/**
 * Created by ken on 3/23/18.
 */
class ShopItemManager private constructor() {

    private var mShopItem: ArrayList<ShopItem> = ArrayList()

    private object Holder {
        val INSTANCE = ShopItemManager()
    }

    init {
        for (i in 0 until 10) {
            val comments = ArrayList<Comment>()
            val shopItem = ShopItem("Item $i", false, comments, "0")
            mShopItem.add(shopItem)
        }
    }

    companion object {
        val instance: ShopItemManager by lazy { Holder.INSTANCE }
    }

    fun getListShopItem(): ArrayList<ShopItem> {
        return mShopItem
    }

    fun updateItem(shopItem: ShopItem) {
        for ((index, item) in mShopItem.withIndex()) {
            if (shopItem.name == item.name) {
                mShopItem[index] = shopItem
            }
        }
    }
}
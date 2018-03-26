package com.fitken.rekotlinexample.actions

import com.fitken.rekotlinexample.explore.ShopItem
import tw.geothings.rekotlin.Action

/**
 * Created by ken on 3/26/18.
 */
data class ActionLike(
        val shopItem: ShopItem
) : Action

data class ActionComment(val shopItem: ShopItem) : Action

data class ActionUpdateShopItemList(val shopItems: ArrayList<ShopItem>) : Action
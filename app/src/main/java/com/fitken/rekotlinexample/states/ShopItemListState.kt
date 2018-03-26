package com.fitken.rekotlinexample.states

import com.fitken.rekotlinexample.explore.ShopItem
import tw.geothings.rekotlin.StateType

/**
 * Created by ken on 3/26/18.
 */
data class ShopItemListState(
        val shopItems: ArrayList<ShopItem>? = null
) : StateType
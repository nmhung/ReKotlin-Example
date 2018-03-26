package com.fitken.rekotlinexample.states

import com.fitken.rekotlinexample.explore.ShopItem
import tw.geothings.rekotlin.StateType

/**
 * Created by ken on 3/26/18.
 */
data class ViewedListState(var shopItems: ArrayList<ShopItem> = ArrayList()
) : StateType
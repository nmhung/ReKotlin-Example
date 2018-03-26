package com.fitken.rekotlinexample.states

import tw.geothings.rekotlin.StateType

/**
 * Created by ken on 3/26/18.
 */
data class AppState(
        val shopItemListState: ShopItemListState? = null,
        val viewedListState: ViewedListState? = null
) : StateType
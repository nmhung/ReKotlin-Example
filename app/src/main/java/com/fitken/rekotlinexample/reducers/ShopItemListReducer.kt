package com.fitken.rekotlinexample.reducers

import com.fitken.rekotlinexample.actions.ActionComment
import com.fitken.rekotlinexample.actions.ActionLike
import com.fitken.rekotlinexample.actions.ActionUpdateShopItemList
import com.fitken.rekotlinexample.states.ShopItemListState
import tw.geothings.rekotlin.Action

/**
 * Created by ken on 3/26/18.
 */

fun shopItemListReducer(action: Action, state: ShopItemListState?): ShopItemListState {
    var state = state ?: ShopItemListState()
    when (action) {
        is ActionLike -> {
            if (state.shopItems != null) {
                for ((index, element) in state.shopItems!!.withIndex()) {
                    if (element.id == action.shopItem.id) {
                        state.shopItems!![index] = action.shopItem
                    }
                }
            }
        }
        is ActionComment -> {
            if (state.shopItems != null) {
                for ((index, element) in state.shopItems!!.withIndex()) {
                    if (element.id == action.shopItem.id) {
                        state.shopItems!![index] = action.shopItem
                    }
                }
            }
        }
        is ActionUpdateShopItemList -> {
            state = state.copy(shopItems = action.shopItems)
        }
    }
    return state
}
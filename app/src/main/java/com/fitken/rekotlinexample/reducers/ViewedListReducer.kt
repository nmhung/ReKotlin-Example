package com.fitken.rekotlinexample.reducers

import com.fitken.rekotlinexample.actions.ActionView
import com.fitken.rekotlinexample.states.ViewedListState
import tw.geothings.rekotlin.Action

/**
 * Created by ken on 3/26/18.
 */

fun viewedListReducer(action: Action, state: ViewedListState?): ViewedListState {
    var state = state ?: ViewedListState()
    when (action) {
        is ActionView -> {
            if (state.shopItems.contains(action.shopItem)) {
                state.shopItems[state.shopItems.indexOf(action.shopItem)] = action.shopItem
            } else {
                state.shopItems.add(action.shopItem)
            }
        }
    }
    return state
}
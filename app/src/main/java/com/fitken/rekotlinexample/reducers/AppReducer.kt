package com.fitken.rekotlinexample.reducers

import com.fitken.rekotlinexample.states.AppState
import tw.geothings.rekotlin.Action

/**
 * Created by ken on 3/26/18.
 */

fun appReducer(action: Action, state: AppState?): AppState =
        AppState(
                shopItemListState = shopItemListReducer(action, state?.shopItemListState),
                viewedListState = viewedListReducer(action, state?.viewedListState)
        )
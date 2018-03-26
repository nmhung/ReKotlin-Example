package com.fitken.rekotlinexample.actions

import com.fitken.rekotlinexample.explore.ShopItem
import tw.geothings.rekotlin.Action

/**
 * Created by ken on 3/26/18.
 */

data class ActionView(val shopItem: ShopItem) : Action
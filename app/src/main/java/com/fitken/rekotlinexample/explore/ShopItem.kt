package com.fitken.rekotlinexample.explore

import java.io.Serializable

/**
 * Created by ken on 3/23/18.
 */
data class ShopItem(
        var name: String,
        var isView: Boolean,
        val comments: ArrayList<Comment>,
        var likeCount: String
) : Serializable{
}
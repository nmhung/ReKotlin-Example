package com.fitken.rekotlinexample.explore

import java.io.Serializable

/**
 * Created by ken on 3/23/18.
 */
data class Comment(
        val name: String,
        val message: String
) : Serializable{
}
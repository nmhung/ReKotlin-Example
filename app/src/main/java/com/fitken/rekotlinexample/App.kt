package com.fitken.rekotlinexample

import android.app.Application
import com.fitken.rekotlinexample.reducers.appReducer
import tw.geothings.rekotlin.Store

/**
 * Created by ken on 3/26/18.
 */

val store = Store(
        reducer = ::appReducer,
        state = null
)

class App : Application() {
}
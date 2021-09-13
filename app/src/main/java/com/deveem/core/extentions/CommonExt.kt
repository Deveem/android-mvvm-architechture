package com.deveem.core.extentions

import android.os.Handler
import android.os.Looper

fun runAfter(delayMillis: Long, method: () -> Unit) {
    Handler(Looper.getMainLooper()).postDelayed({
        method()
    }, delayMillis)
}
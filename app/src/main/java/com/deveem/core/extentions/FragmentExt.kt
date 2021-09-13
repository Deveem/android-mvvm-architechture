package com.deveem.core.extentions

import android.view.View
import android.widget.Toast
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment

fun Fragment.inflate(layout: Int): View? {
    return try {
        layoutInflater.inflate(layout, null)
    } catch (e: Exception) {
        null
    }
}

fun Fragment.showToast(message: String?) {
    context?.let { Toast.makeText(it, message, Toast.LENGTH_LONG).show() }
}
fun Fragment.showToast(@StringRes resId: Int) {
    context?.let { Toast.makeText(it, it.getString(resId), Toast.LENGTH_LONG).show() }
}
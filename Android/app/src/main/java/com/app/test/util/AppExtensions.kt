package com.app.test.util

import android.app.Activity
import android.content.Context
import android.view.WindowManager
import android.view.inputmethod.InputMethodManager

/*show/hide keyboard*/
fun hideKeyBoard(activity: Activity) {
    activity.window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN)
}

fun showKeyBoard(context: Context) {
    (context.getSystemService(Context.INPUT_METHOD_SERVICE)as InputMethodManager).
            toggleSoftInput(InputMethodManager.SHOW_FORCED, InputMethodManager.HIDE_IMPLICIT_ONLY)
}
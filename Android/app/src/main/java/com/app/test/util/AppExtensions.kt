package com.app.test.util

import android.app.Activity
import android.content.Context
import android.databinding.BindingAdapter
import android.view.WindowManager
import android.view.inputmethod.InputMethodManager
import android.widget.ImageView
import com.app.test.R
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

/*show/hide keyboard*/
fun hideKeyBoard(activity: Activity) {
    activity.window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN)
}

fun showKeyBoard(context: Context) {
    (context.getSystemService(Context.INPUT_METHOD_SERVICE)as InputMethodManager).
            toggleSoftInput(InputMethodManager.SHOW_FORCED, InputMethodManager.HIDE_IMPLICIT_ONLY)
}

@BindingAdapter("android:src")
fun setImageView(imageView: ImageView, imageUrl:String) {
    Glide.with(imageView.context)
            .load(imageUrl)
            .apply(RequestOptions().placeholder(R.mipmap.ic_launcher))
            .into(imageView)
}
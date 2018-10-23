package com.app.test.util

import android.app.Activity
import android.content.Context
import android.content.Intent
import com.app.test.R

object ActivityUtils {

    fun openActivity(context: Context, activity: Class<*>) {
        val intent = Intent(context, activity)
        context.startActivity(intent)
        //(context as Activity).overridePendingTransition(R.anim.in_from_right, R.anim.out_to_left)
    }

    fun openActivityAndFinish(context: Context, activity: Class<*>) {
        val intent = Intent(context, activity)
        context.startActivity(intent)
        (context as Activity).finish()
        //context.overridePendingTransition(R.anim.in_from_right, R.anim.out_to_left)
    }
}
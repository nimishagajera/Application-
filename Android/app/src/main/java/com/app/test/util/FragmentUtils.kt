package com.app.test.util

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager


class FragmentUtils(private var fragmentManager: FragmentManager?) {

    fun replaceFragment(container: Int, fragment: Fragment) {

        fragmentManager!!
                .beginTransaction()
                .setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out)
                .replace(container, fragment)
                .commitAllowingStateLoss()
    }


    fun addFragment(container: Int, fragment: Fragment) {

        fragmentManager!!
                .beginTransaction()
                //.setCustomAnimations(R.animator.enter_from_right, R.animator.exit_to_left, R.animator.enter_from_left, R.animator.exit_to_right)
                .add(container, fragment)
                .addToBackStack(null)
                .commit()
    }


}

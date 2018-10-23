package com.app.test.ui.base

import android.app.Dialog
import android.content.SharedPreferences
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.support.v4.content.ContextCompat
import android.text.method.PasswordTransformationMethod
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.widget.EditText
import android.widget.ImageView
import com.app.test.CustomApplication
import com.app.test.R
import com.app.test.util.FragmentUtils
import com.app.test.util.hideKeyBoard
import guru.jini.ilf.utils.LoadingViewUtils
import javax.inject.Inject

abstract class BaseDialogFragment: DialogFragment(), BaseContract.BaseView {

    protected lateinit var fragmentUtils: FragmentUtils

    @Inject
    lateinit var preferences: SharedPreferences

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        CustomApplication.appComponent.inject(this)
        fragmentUtils = FragmentUtils(fragmentManager)
    }

    override fun onStart() {
        super.onStart()
        val dialog = dialog
        if (dialog != null) {
            val width = ViewGroup.LayoutParams.MATCH_PARENT
            val height = ViewGroup.LayoutParams.WRAP_CONTENT
            dialog.window!!.setGravity(Gravity.CENTER)
            dialog.window!!.setLayout(width, height)
        }
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val dialog = super.onCreateDialog(savedInstanceState)
        dialog.window.requestFeature(Window.FEATURE_NO_TITLE)

        return dialog
    }

    override fun showLoading() {
        context?.let { LoadingViewUtils.showLoading(it) }
    }

    override fun hideLoading() {
        LoadingViewUtils.hideLoading()
    }

    protected fun setLayoutSize() {
        val dialog = dialog
        if (dialog != null) {
            val width = ViewGroup.LayoutParams.WRAP_CONTENT
            val height = ViewGroup.LayoutParams.WRAP_CONTENT
            dialog.window!!.setGravity(Gravity.CENTER)
            dialog.window!!.setLayout(width, height)
            dialog.window.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        }
    }

    override fun onPause() {
        super.onPause()
        activity?.let { hideKeyBoard(it) }
    }
}
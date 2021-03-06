package com.app.test.ui.base

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.View
import com.app.test.CustomApplication
import com.app.test.persistance.dao.UserArticleDao
import com.app.test.ui.main.MainActivity
import com.app.test.util.FragmentUtils
import com.app.test.util.hideKeyBoard
import guru.jini.ilf.utils.LoadingViewUtils
import javax.inject.Inject


abstract class BaseFragment: Fragment(), BaseContract.BaseView {

    @Inject
    lateinit var preferences: SharedPreferences

    @Inject
    lateinit var userArticleDao: UserArticleDao

    protected lateinit var fragmentUtils: FragmentUtils
    protected lateinit var mainActivity: MainActivity
    protected lateinit var mContext: Context

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (activity is MainActivity) {
            mainActivity = activity as MainActivity
        }
        CustomApplication.appComponent.inject(this)
        fragmentUtils = FragmentUtils(fragmentManager)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mContext = context
    }

    override fun onResume() {
        super.onResume()
        if (activity is MainActivity) {
            mainActivity = activity as MainActivity
            if (getToolbarTitle() != null)
                mainActivity.setToolbarTitle(getToolbarTitle()!!)

            if (showBackButton())
                mainActivity.showToolbarBack()
            else
                mainActivity.hideToolbarBack()
        } else { }
    }

    override fun onPause() {
        super.onPause()
        activity?.let { hideKeyBoard(it) }
    }

    override fun showLoading() {
        activity?.let { LoadingViewUtils.showLoading(it) }
    }

    override fun hideLoading() {
        LoadingViewUtils.hideLoading()
    }

    protected abstract fun getToolbarTitle(): String?

    protected abstract fun showBackButton(): Boolean
}
package com.app.test.ui.base

import android.content.SharedPreferences
import android.os.Bundle
import android.support.annotation.NonNull
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.widget.ImageView
import android.widget.TextView
import com.app.test.CustomApplication
import com.app.test.R
import com.app.test.util.FragmentUtils
import guru.jini.ilf.utils.LoadingViewUtils
import javax.inject.Inject

abstract class BaseActivity : AppCompatActivity(), BaseContract.BaseView {

    @Inject
    lateinit var preferences: SharedPreferences

    private lateinit var mPresenter: BaseContract.BasePresenter

    protected lateinit var fragmentUtils: FragmentUtils

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        fragmentUtils = FragmentUtils(supportFragmentManager)
        CustomApplication.appComponent.inject(this)
        mPresenter = BasePresenter(this)
    }

    override fun onResume() {
        super.onResume()
        mPresenter.subscribe()
    }

    override fun onPause() {
        super.onPause()
        mPresenter.unSubscribe()
    }

    override fun showLoading() {
        LoadingViewUtils.showLoading(this)
    }

    override fun hideLoading() {
        LoadingViewUtils.hideLoading()
    }

}
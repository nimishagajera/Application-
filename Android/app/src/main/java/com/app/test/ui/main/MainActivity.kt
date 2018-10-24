package com.app.test.ui.main

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.widget.Toolbar
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.app.test.R
import com.app.test.databinding.ActivityMainBinding
import com.app.test.ui.article.ArticleFragment
import com.app.test.ui.base.BaseActivity
import com.app.test.ui.review.ReviewFragment

class MainActivity : BaseActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var toolbar: Toolbar
    private lateinit var txtToolbarTitle: TextView
    private lateinit var imgToolbarBack: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        toolbar = binding.toolbar.toolbar

        setSupportActionBar(toolbar)
        val view = layoutInflater.inflate(R.layout.layout_toolbar, null)
        toolbar.addView(view)

        txtToolbarTitle = toolbar.findViewById(R.id.txt_toolbar_title)
        imgToolbarBack = toolbar.findViewById(R.id.img_toolbar_back)

        fragmentUtils.addFragment(R.id.container, ArticleFragment())
    }

    fun setToolbarTitle(strTitle: String?) {
        if (strTitle != null) {
            txtToolbarTitle.text = strTitle
            if (txtToolbarTitle.visibility != View.VISIBLE)
                txtToolbarTitle.visibility = View.VISIBLE
        } else {
            if (txtToolbarTitle.visibility != View.GONE)
                txtToolbarTitle.visibility = View.GONE
        }
    }

    fun showToolbarBack() {
        if (imgToolbarBack.visibility != View.VISIBLE)
        imgToolbarBack.visibility = View.VISIBLE
    }

    fun hideToolbarBack() {
        if (imgToolbarBack.visibility != View.GONE)
        imgToolbarBack.visibility = View.GONE
    }

    override fun onBackPressed() {
        if (fragmentManager.getBackStackEntryCount() > 0) {
            fragmentManager.popBackStack();
        } else {
            super.onBackPressed();
        }
    }

    override fun onStop() {
        super.onStop()
        this.finish()
    }
}

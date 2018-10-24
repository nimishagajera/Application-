package com.app.test.ui.start

import android.databinding.DataBindingUtil
import android.os.Bundle
import com.app.test.R
import com.app.test.databinding.ActivityStartBinding
import com.app.test.ui.base.BaseActivity
import com.app.test.ui.main.MainActivity
import com.app.test.util.ActivityUtils

class StartActivity : BaseActivity() {

    private lateinit var binding: ActivityStartBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_start)
        userArticleDao.deleteAllArticles()
        binding.btnStart.setOnClickListener {
            ActivityUtils.openActivityAndFinish(this@StartActivity, MainActivity::class.java)
        }

    }
}

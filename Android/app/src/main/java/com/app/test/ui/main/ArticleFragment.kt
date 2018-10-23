package com.app.test.ui.main


import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import com.app.test.R
import com.app.test.databinding.FragmentArticleBinding
import com.app.test.ui.base.BaseFragment

class ArticleFragment : BaseFragment() {

    private lateinit var binding: FragmentArticleBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_article, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.recyclerArticle.layoutManager = LinearLayoutManager(mContext,LinearLayout.HORIZONTAL,false)


    }

    override fun getToolbarTitle(): String? = getString(R.string.str_articles)

    override fun showBackButton(): Boolean = false
}

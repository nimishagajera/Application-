package com.app.test.ui.review


import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.app.test.R
import com.app.test.databinding.FragmentReviewDataBinding
import com.app.test.persistance.entity.UserArticle
import com.app.test.ui.base.BaseFragment

class ReviewDataFragment : BaseFragment() {

    private lateinit var binding: FragmentReviewDataBinding
    private lateinit var listAdapter: ReviewListAdapter
    private lateinit var gridAdapter: ReviewGridAdapter
    private lateinit var articleList: MutableList<UserArticle>

    fun newInstance(reviewData: String): ReviewDataFragment {
        val fragment = ReviewDataFragment()
        val bundle = Bundle()
        bundle.putString("review_type", reviewData)
        fragment.arguments = bundle
        return fragment
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_review_data, container, false)
        articleList = ArrayList()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        articleList.addAll(userArticleDao.article)

        listAdapter = ReviewListAdapter(articleList)
        gridAdapter = ReviewGridAdapter(articleList)

        if (arguments != null)
            if (arguments?.getString("review_type") == "grid") {
                binding.recyclerViewData.layoutManager = GridLayoutManager(mContext,2)
                binding.recyclerViewData.adapter = gridAdapter
            } else {
                binding.recyclerViewData.layoutManager = LinearLayoutManager(mContext,LinearLayoutManager.VERTICAL,false)
                binding.recyclerViewData.adapter = listAdapter
            }

        Log.d("user-article", userArticleDao.article.toString())
    }

    override fun getToolbarTitle(): String? = null

    override fun showBackButton(): Boolean = false
}

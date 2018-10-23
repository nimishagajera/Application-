package com.app.test.ui.review


import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.app.test.R
import com.app.test.databinding.FragmentReviewDataBinding
import com.app.test.model.Article
import com.app.test.ui.base.BaseFragment

class ReviewDataFragment : BaseFragment() {

    private lateinit var binding: FragmentReviewDataBinding
    private lateinit var adapter: ReviewListAdapter
    private lateinit var articleList: ArrayList<Article>

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

        for(i in 0 until 20) {
            articleList.add(Article("Hello ".plus(i),ContextCompat.getDrawable(mContext,R.mipmap.ic_launcher)))
        }

        adapter = ReviewListAdapter(articleList)
        binding.recyclerViewData.adapter = adapter
        if (arguments != null)
            if (arguments?.getString("review_type") == "grid")
                binding.recyclerViewData.layoutManager = GridLayoutManager(mContext,2)
        else
                binding.recyclerViewData.layoutManager = LinearLayoutManager(mContext,LinearLayoutManager.VERTICAL,false)

    }

    override fun getToolbarTitle(): String? = null

    override fun showBackButton(): Boolean = false
}

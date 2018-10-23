package com.app.test.ui.review


import android.databinding.DataBindingUtil
import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.support.v4.content.ContextCompat
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView

import com.app.test.R
import com.app.test.databinding.FragmentReviewBinding
import com.app.test.ui.base.BaseFragment

class ReviewFragment : BaseFragment() {

    private lateinit var binding: FragmentReviewBinding
    private lateinit var adapter:ViewPagerAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_review, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = ViewPagerAdapter(childFragmentManager)
        adapter.addFrag(ReviewDataFragment().newInstance("list"), "ListView")
        adapter.addFrag(ReviewDataFragment().newInstance("grid"), "GridView")
        binding.viewpager.adapter = adapter
        binding.viewpager.currentItem = 0
        adjustTabLayout()
    }

    fun adjustTabLayout() {
        binding.tabLayout.setupWithViewPager(binding.viewpager)
        val slidingTabStrip = binding.tabLayout.getChildAt(0) as ViewGroup
        for (tabIndex in 0 until binding.tabLayout.tabCount) {
            val tabTextView = ((binding.tabLayout.getChildAt(0) as LinearLayout).getChildAt(tabIndex) as LinearLayout).getChildAt(1) as TextView
            tabTextView.setAllCaps(true)
            tabTextView.setTextColor(ContextCompat.getColor(context!!, android.R.color.white))
            val tab = slidingTabStrip.getChildAt(tabIndex)
            val layoutParams = tab.layoutParams as LinearLayout.LayoutParams
            layoutParams.weight = 1f
            tab.layoutParams = layoutParams
        }
    }

    override fun getToolbarTitle(): String? = getString(R.string.str_review)

    override fun showBackButton(): Boolean = true


    internal inner class ViewPagerAdapter(manager: FragmentManager) : FragmentPagerAdapter(manager) {
        private val mFragmentList = ArrayList<Fragment>()
        private val mFragmentTitleList = ArrayList<String>()

        override fun getItem(position: Int): Fragment {
            return mFragmentList[position]
        }

        override fun getCount(): Int {
            return mFragmentList.size
        }

        fun addFrag(fragment: Fragment, title: String) {
            mFragmentList.add(fragment)
            mFragmentTitleList.add(title)
        }

        override fun getPageTitle(position: Int): CharSequence? {
            return mFragmentTitleList[position]
        }
    }
}



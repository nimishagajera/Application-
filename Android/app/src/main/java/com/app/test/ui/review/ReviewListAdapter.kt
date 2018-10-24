package com.app.test.ui.review

import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.app.test.BR
import com.app.test.R
import com.app.test.databinding.LayoutReviewListArticleBinding
import com.app.test.model.Article
import com.app.test.persistance.entity.UserArticle

class ReviewListAdapter(private val articleList: List<UserArticle>):RecyclerView.Adapter<ReviewListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.layout_review_list_article,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = articleList.size

    override fun onBindViewHolder(viewholder: ViewHolder, position: Int) {
        val article = articleList[position]

        viewholder.binding?.setVariable(BR.article,article)
        viewholder.binding?.executePendingBindings()
    }

    class ViewHolder(val view: View):RecyclerView.ViewHolder(view){
        var binding: LayoutReviewListArticleBinding? = DataBindingUtil.bind(view)
    }

}
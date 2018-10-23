package com.app.test.ui.article

import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.app.test.BR
import com.app.test.R
import com.app.test.databinding.LayoutArticleItemBinding
import com.app.test.model.Article

class ArticleAdapter(private val articleList: List<Article>):RecyclerView.Adapter<ArticleAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.layout_article_item,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = articleList.size

    override fun onBindViewHolder(viewholder: ViewHolder, position: Int) {
        val article = articleList[position]
        for (media in article.media) {
            viewholder.binding?.setVariable(BR.media,media)
            viewholder.binding?.executePendingBindings()
        }
    }

    class ViewHolder(val view:View):RecyclerView.ViewHolder(view){
        var binding: LayoutArticleItemBinding?= DataBindingUtil.bind(view)
    }
}
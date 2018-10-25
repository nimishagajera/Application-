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
import com.app.test.persistance.dao.UserArticleDao
import com.app.test.persistance.entity.UserArticle
import com.app.test.ui.review.ReviewFragment
import com.app.test.util.FragmentUtils

class ArticleAdapter(private val recyclerView: RecyclerView,
                     private val  fragmentUtils: FragmentUtils,
                     private val userArticleDao: UserArticleDao,
                     private val articleList: List<Article>):RecyclerView.Adapter<ArticleAdapter.ViewHolder>() {

    private var likedCount = 0

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.layout_article_item,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = articleList.size

    override fun onBindViewHolder(viewholder: ViewHolder, position: Int) {
        val article = articleList[position]
        var articleImage = ""
        for (media in article.media) {
            articleImage = media.uri
            viewholder.binding?.setVariable(BR.media,media)
            viewholder.binding?.executePendingBindings()
        }

        viewholder.binding?.btnLike?.setOnClickListener {
            recyclerView.scrollToPosition(position+1)
            likedCount++
            userArticleDao.insertArticle(UserArticle(article.title,articleImage,true))
        }

        viewholder.binding?.btnDislike?.setOnClickListener {
            recyclerView.scrollToPosition(position+1)
            userArticleDao.insertArticle(UserArticle(article.title,articleImage,false))
        }

        viewholder.binding?.txtCount?.text = viewholder.binding?.imgArticle?.context?.getString(R.string.str_liked_articles)
                .plus(likedCount.toString().plus("/").plus(articleList.size))

        if (position == itemCount -1) {
            viewholder.binding?.btnReview?.visibility = View.VISIBLE
            viewholder.binding?.txtNoArticle?.visibility = View.VISIBLE
            viewholder.binding?.groupArticle?.visibility = View.GONE
        }

        viewholder.binding?.btnReview?.setOnClickListener {
            fragmentUtils.addFragment(R.id.container, ReviewFragment())
        }
    }

    class ViewHolder(val view:View):RecyclerView.ViewHolder(view){
        var binding: LayoutArticleItemBinding?= DataBindingUtil.bind(view)
    }
}
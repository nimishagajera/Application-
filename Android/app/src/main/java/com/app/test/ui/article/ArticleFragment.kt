package com.app.test.ui.article


import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import com.app.test.R
import com.app.test.databinding.FragmentArticleBinding
import com.app.test.model.Article
import com.app.test.model.ArticleResponse
import com.app.test.ui.base.BaseFragment
import android.support.v7.widget.PagerSnapHelper



class ArticleFragment : BaseFragment(),ArticleContract.View {

    private lateinit var binding: FragmentArticleBinding
    private lateinit var presenter: ArticleContract.Presenter
    private lateinit var adapter: ArticleAdapter
    private lateinit var articleList: ArrayList<Article>

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_article, container, false)
        presenter = ArticlePresenter(this)
        articleList = ArrayList()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        showLoading()
        presenter.retrieveArticles(1,"de_DE",10)
        binding.recyclerArticle.layoutManager = LinearLayoutManager(mContext,LinearLayout.HORIZONTAL,false)
        adapter = ArticleAdapter(binding.recyclerArticle,fragmentUtils, userArticleDao,articleList)
        binding.recyclerArticle.adapter = adapter

        val snapHelper = PagerSnapHelper()
        snapHelper.attachToRecyclerView(binding.recyclerArticle)

        binding.btnRetry.setOnClickListener {
            showLoading()
            presenter.retrieveArticles(1,"de_DE",10)
        }
    }

    override fun getToolbarTitle(): String? = getString(R.string.str_selection)

    override fun showBackButton(): Boolean = false

    override fun onRetrieveArticlesSuccess(response: ArticleResponse) {
        hideLoading()
        binding.recyclerArticle.visibility = View.VISIBLE
        binding.groupError.visibility = View.GONE
        articleList.addAll(response._embedded.articles)
        adapter.notifyDataSetChanged()

    }

    override fun onRetrieveArticlesFailed() {
        hideLoading()
        binding.recyclerArticle.visibility = View.GONE
        binding.groupError.visibility = View.VISIBLE
   }

    override fun onPause() {
        super.onPause()
        presenter.unSubscribe()
    }
}

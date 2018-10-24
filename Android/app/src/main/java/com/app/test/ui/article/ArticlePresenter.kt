package com.app.test.ui.article

import com.app.test.model.ArticleResponse
import com.app.test.ui.base.BasePresenter
import com.app.test.util.RxUtils

class ArticlePresenter(private val view: ArticleContract.View):BasePresenter(view), ArticleContract.Presenter {

    override fun retrieveArticles(appDomain: Int, locale: String, limit: Int) {
        mSubscription.add(
                apiService.retrieveArticles(appDomain,locale,limit)
                        .compose(RxUtils.applySchedulers())
                        .subscribe(
                                { response: ArticleResponse ->
                                    view.hideLoading()
                                    view.onRetrieveArticlesSuccess(response)
                                },
                                { _: Throwable ->
                                    view.hideLoading()
                                    view.onRetrieveArticlesFailed()
                                },
                                { view.hideLoading() }
                        )
        )

    }
}
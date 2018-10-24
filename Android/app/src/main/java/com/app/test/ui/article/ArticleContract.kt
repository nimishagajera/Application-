package com.app.test.ui.article

import com.app.test.model.ArticleResponse
import com.app.test.ui.base.BaseContract

interface ArticleContract {

    interface View : BaseContract.BaseView {

        fun onRetrieveArticlesSuccess(response: ArticleResponse)

        fun onRetrieveArticlesFailed()

    }

    interface Presenter : BaseContract.BasePresenter {

        fun retrieveArticles(appDomain:Int,locale:String,limit:Int)

    }
}
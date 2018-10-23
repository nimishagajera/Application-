package com.app.test.ui.main

import com.app.test.ui.base.BasePresenter

class MainPresenter(private val view:MainContract.View):BasePresenter(view),MainContract.Presenter {
}
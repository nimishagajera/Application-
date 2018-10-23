package com.app.test.ui.base

interface BaseContract {

    interface BaseView {

        fun showLoading()

        fun hideLoading()
    }

    interface BasePresenter {

        fun subscribe()

        fun unSubscribe()
    }
}
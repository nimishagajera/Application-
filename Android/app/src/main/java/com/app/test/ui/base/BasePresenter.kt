package com.app.test.ui.base

import android.content.Context
import android.support.annotation.NonNull
import com.app.test.CustomApplication
import com.app.test.app.network.APIService
import rx.subscriptions.CompositeSubscription
import javax.inject.Inject

open class BasePresenter(@NonNull var mView: BaseContract.BaseView): BaseContract.BasePresenter {

    protected lateinit var mSubscription: CompositeSubscription

    @Inject
    protected lateinit var apiService: APIService

    @Inject
    protected lateinit var context:Context

    init {
        CustomApplication.appComponent.inject(this)
        subscribe()
    }

    override fun subscribe() {
        mSubscription = CompositeSubscription()
    }

    override fun unSubscribe() {
        if (mSubscription != null) {
            mSubscription.clear()
        }
    }
}
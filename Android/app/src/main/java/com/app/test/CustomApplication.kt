package com.app.test

import android.app.Application
import com.app.test.app.di.AppComponent
import com.app.test.app.di.DaggerAppComponent
import com.app.test.app.di.module.ContextModule
import com.app.test.app.di.module.NetworkModule
import com.app.test.app.di.module.SharedPreferenceModule

class CustomApplication: Application() {

    companion object {
        lateinit var appComponent: AppComponent
    }

    override fun onCreate() {
        initComponent()
        super.onCreate()
    }

    protected fun initComponent() {
        appComponent = DaggerAppComponent.builder()
                .contextModule(ContextModule(applicationContext))
                .networkModule(NetworkModule())
                .sharedPreferenceModule(SharedPreferenceModule(applicationContext))
                .build()
    }

}
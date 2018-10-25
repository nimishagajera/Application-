package com.app.test

import android.app.Application
import com.app.test.app.di.AppComponent
import com.app.test.app.di.DaggerAppComponent
import com.app.test.app.di.module.ContextModule
import com.app.test.app.di.module.DatabaseModule
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

    private fun initComponent() {
        appComponent = DaggerAppComponent.builder()
                .contextModule(ContextModule(applicationContext))
                .sharedPreferenceModule(SharedPreferenceModule(applicationContext))
                .networkModule(NetworkModule())
                .databaseModule(DatabaseModule())
                .build()
    }

}
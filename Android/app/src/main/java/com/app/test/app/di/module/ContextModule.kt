package com.app.test.app.di.module

import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
open class ContextModule(private val context: Context) {

    @Singleton
    @Provides
    open fun getContext():Context {
        return context
    }
}
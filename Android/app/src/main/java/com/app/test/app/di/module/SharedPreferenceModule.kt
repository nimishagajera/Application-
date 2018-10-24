package com.app.test.app.di.module

import android.content.Context
import android.content.SharedPreferences
import com.app.test.util.AppConstants
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class SharedPreferenceModule(private val context: Context) {

    @Provides
    @Singleton
    fun provideSharedPreferences(): SharedPreferences {
        return context.getSharedPreferences(AppConstants.sharedPreference, Context.MODE_PRIVATE)
    }
}
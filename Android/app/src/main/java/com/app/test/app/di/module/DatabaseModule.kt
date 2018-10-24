package com.app.test.app.di.module

import android.content.Context
import com.app.test.persistance.CustomDatabase
import com.app.test.persistance.dao.UserArticleDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule {

    @Singleton
    @Provides
    fun getDBInstance(context: Context): CustomDatabase = CustomDatabase.getDatabase(context)

    @Singleton
    @Provides
    fun userArticleDao(context: Context):UserArticleDao = getDBInstance(context).userArticleDao()
}
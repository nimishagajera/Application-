package com.app.test.persistance

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import com.app.test.persistance.dao.UserArticleDao
import com.app.test.persistance.entity.UserArticle

@Database(entities = [UserArticle::class], version = 1)
abstract class CustomDatabase:RoomDatabase() {

    companion object {
        private lateinit var INSTANCE: CustomDatabase

        fun getDatabase(context: Context): CustomDatabase {

            INSTANCE = Room.databaseBuilder(context, CustomDatabase::class.java, "app-database")
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build()

            return INSTANCE
        }
    }

    abstract fun userArticleDao(): UserArticleDao
}
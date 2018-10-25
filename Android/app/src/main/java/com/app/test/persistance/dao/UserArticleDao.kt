package com.app.test.persistance.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import com.app.test.persistance.entity.UserArticle

@Dao
interface UserArticleDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertArticle(likedArticles: UserArticle)

    @get:Query("SELECT * FROM articles")
    val articles: List<UserArticle>

    @Query("DELETE from articles")
    fun deleteAllArticles()

}
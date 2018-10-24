package com.app.test.persistance.entity

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import javax.annotation.Nonnull


@Entity(tableName = "articles")
class UserArticle(var articleTitle: String, var articleImage: String, var isLiked: Boolean) {

    @PrimaryKey(autoGenerate = true)
    @Nonnull
    var id: Int = 0

    override fun toString(): String {
        return "UserArticle(articleTitle='$articleTitle', articleImage='$articleImage', isLiked=$isLiked, id=$id)"
    }

}
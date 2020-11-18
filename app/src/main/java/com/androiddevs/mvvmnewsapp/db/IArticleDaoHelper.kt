package com.androiddevs.mvvmnewsapp.db

import androidx.lifecycle.LiveData
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.androiddevs.mvvmnewsapp.models.Article

interface IArticleDaoHelper {

    suspend fun upsert(article: Article): Long

    fun getAllArticles() : LiveData<List<Article>>

    suspend fun deleteArticle(article: Article)

}
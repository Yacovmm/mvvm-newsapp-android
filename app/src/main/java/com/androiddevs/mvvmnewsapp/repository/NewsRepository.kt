package com.androiddevs.mvvmnewsapp.repository

import com.androiddevs.mvvmnewsapp.api.RetrofitInstance
import com.androiddevs.mvvmnewsapp.db.ArticleDatabase
import com.androiddevs.mvvmnewsapp.models.Article

class NewsRepository(val db: ArticleDatabase) {

    suspend fun getBreakingNews(coutryCode: String, pageNumber: Int) =
        RetrofitInstance.api.getBreakingNews(coutryCode, pageNumber)


    suspend fun searchNews(searchQuery: String, pageNumber: Int) =
        RetrofitInstance.api.searchForNews(searchQuery, pageNumber)

    suspend fun upsert(article: Article) =
        db.getArticleDao().upsert(article)

    fun getSavesNews() = db.getArticleDao().getAllArticles()

    suspend fun deleteArticle(article: Article) =
        db.getArticleDao().deleteArticle(article)

}
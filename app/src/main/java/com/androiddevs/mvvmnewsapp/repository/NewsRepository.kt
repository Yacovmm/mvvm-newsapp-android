package com.androiddevs.mvvmnewsapp.repository

import com.androiddevs.mvvmnewsapp.api.INewsApiHelper
import com.androiddevs.mvvmnewsapp.db.ArticleDao
import com.androiddevs.mvvmnewsapp.models.Article
import javax.inject.Inject

class NewsRepository @Inject constructor(
    val articleDao: ArticleDao,
    val newsApiHelper: INewsApiHelper
) {

    suspend fun getBreakingNews(coutryCode: String, pageNumber: Int) =
        newsApiHelper.getBreakingNews(coutryCode, pageNumber)


    suspend fun searchNews(searchQuery: String, pageNumber: Int) =
        newsApiHelper.searchForNews(searchQuery, pageNumber)

    suspend fun upsert(article: Article) =
        articleDao.upsert(article)

    fun getSavesNews() = articleDao.getAllArticles()

    suspend fun deleteArticle(article: Article) =
        articleDao.deleteArticle(article)

}
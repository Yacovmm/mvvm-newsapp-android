package com.androiddevs.mvvmnewsapp.db

import androidx.lifecycle.LiveData
import com.androiddevs.mvvmnewsapp.models.Article
import javax.inject.Inject

class ArticleDaoHelperImplementation @Inject constructor(private val articleDao: ArticleDao)
    : IArticleDaoHelper {

    override suspend fun upsert(article: Article): Long = articleDao.upsert(article)

    override fun getAllArticles(): LiveData<List<Article>> = articleDao.getAllArticles()

    override suspend fun deleteArticle(article: Article) {
        articleDao.deleteArticle(article)
    }
}
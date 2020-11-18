package com.androiddevs.mvvmnewsapp.api

import com.androiddevs.mvvmnewsapp.models.NewsResponse
import retrofit2.Response
import javax.inject.Inject

class NewsApiHelperImplementation @Inject constructor(private val apiService: NewsAPIService) : INewsApiHelper {

    override suspend fun getBreakingNews(
        countryCode: String,
        pageNumber: Int
    ): Response<NewsResponse> = apiService.getBreakingNews(countryCode, pageNumber)

    override suspend fun searchForNews(
        searchQuery: String,
        pageNumber: Int
    ): Response<NewsResponse> = apiService.searchForNews(searchQuery, pageNumber)
}
package com.androiddevs.mvvmnewsapp.api

import com.androiddevs.mvvmnewsapp.models.NewsResponse
import com.androiddevs.mvvmnewsapp.utils.Constants
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface INewsApiHelper {

    suspend fun getBreakingNews(
        countryCode: String = "br",
        pageNumber: Int = 1
    ) : Response<NewsResponse>

    suspend fun searchForNews(
        searchQuery: String,
        pageNumber: Int = 1
    ) : Response<NewsResponse>
}
package com.androiddevs.mvvmnewsapp.di

import com.androiddevs.mvvmnewsapp.BuildConfig
import com.androiddevs.mvvmnewsapp.api.INewsApiHelper
import com.androiddevs.mvvmnewsapp.api.NewsAPIService
import com.androiddevs.mvvmnewsapp.api.NewsApiHelperImplementation
import com.androiddevs.mvvmnewsapp.utils.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    fun provideOkHttpClient() = if (BuildConfig.DEBUG) {
        val logging = HttpLoggingInterceptor()
        logging.setLevel(HttpLoggingInterceptor.Level.BODY)
        OkHttpClient.Builder()
            .addInterceptor(logging)
            .build()
    } else {
        OkHttpClient.Builder()
            .build()
    }

    @Singleton
    @Provides
    fun provideRetrofitInstance(client: OkHttpClient) =
        Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()

    @Singleton
    @Provides
    fun provideNewsApiService(retrofitInstance: Retrofit) =
        retrofitInstance.create(NewsAPIService::class.java)

    @Singleton
    @Provides
    fun provideNewsApiHelper(apiHelperImpl: NewsApiHelperImplementation) : INewsApiHelper =
        apiHelperImpl

}

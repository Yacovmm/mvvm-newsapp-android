package com.androiddevs.mvvmnewsapp.di

import android.content.Context
import androidx.room.Room
import com.androiddevs.mvvmnewsapp.db.ArticleDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideArticleDatabase(
        @ApplicationContext context: Context
    ) =
        Room.databaseBuilder(
            context.applicationContext,
            ArticleDatabase::class.java,
            "article_db.db"
        ).build()

    @Singleton
    @Provides
    fun provideArticleDao(articleDatabase: ArticleDatabase) =
        articleDatabase.getArticleDao()


}
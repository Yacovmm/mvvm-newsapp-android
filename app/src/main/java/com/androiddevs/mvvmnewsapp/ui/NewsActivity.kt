package com.androiddevs.mvvmnewsapp.ui

import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.androiddevs.mvvmnewsapp.R
import com.androiddevs.mvvmnewsapp.db.ArticleDatabase
import com.androiddevs.mvvmnewsapp.repository.NewsRepository
import kotlinx.android.synthetic.main.activity_main.*

class NewsActivity : AppCompatActivity() {

    lateinit var viewModel: NewsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        IntentFilter(Intent.ACTION_PROCESS_TEXT)

        val repository = NewsRepository(ArticleDatabase(this))
        val viewmodelProviderFactory = NewsViewModelProviderFactory(application, repository)
        viewModel = ViewModelProvider(this, viewmodelProviderFactory).get(NewsViewModel::class.java)

        bottomNavigationView.setupWithNavController((newsNavHostFragment.findNavController()))
    }
}

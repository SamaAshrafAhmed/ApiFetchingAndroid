package com.example.apidepi

import android.content.Context
import android.content.res.Configuration
import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.apidepi.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import java.util.Locale

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    val TAG ="abc"
    lateinit var binding:ActivityMainBinding
    lateinit var viewModel: AlbumViewModel
    lateinit var albumsList:MutableList<Album>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        viewModel = ViewModelProvider(this).get(AlbumViewModel::class.java)
        setContentView(binding.root)
        albumsList = mutableListOf()
        viewModel.fetchAlbums()
        viewModel.album.observe(this, Observer {
            for(i in it){
                albumsList.add(Album(i.userId, i.id, i.title))
            }
            binding.albumsRv.adapter = AlbumAdapter(albumsList)
        })

    }

    fun setLocalization(context: Context, languageCode:String){
        val locale = Locale(languageCode)
        Locale.setDefault(locale)
        val config = Configuration(context.resources.configuration)
        config.setLocale(locale)
        context.createConfigurationContext(config)
        recreate()

    }
}
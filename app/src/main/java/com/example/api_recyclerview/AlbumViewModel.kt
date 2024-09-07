package com.example.apidepi

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AlbumViewModel @Inject constructor(private val albumRepo: AlbumRepo):ViewModel(){
    private val _albums =MutableLiveData<List<Album>>()
    val album:LiveData<List<Album>> = _albums

    fun fetchAlbums(){
        viewModelScope.launch {
            val response= albumRepo.getAlbums()
            _albums.postValue(response)
        }
    }
}
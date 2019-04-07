package com.usman.mvvmsample.features.viewmodel

import androidx.lifecycle.LiveData
import com.usman.mvvmsample.core.BaseResponse
import com.usman.mvvmsample.core.BaseViewModel
import com.usman.mvvmsample.features.model.Album
import com.usman.mvvmsample.features.repository.AlbumRepo
import javax.inject.Inject

/**
 * Created by Muhammad Usman on 1/31/2019.
 */
class AlbumsViewModel @Inject constructor(private val repo: AlbumRepo) : BaseViewModel() {
    private lateinit var albums: LiveData<BaseResponse<List<Album>>>

    fun getAlbums(): LiveData<BaseResponse<List<Album>>> {

        if (!::albums.isInitialized) {
            albums = repo.getLiveAlbums()
        }

        return albums
    }

}
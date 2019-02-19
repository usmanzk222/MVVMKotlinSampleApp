package com.usman.mvvmsample.features.repository

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MediatorLiveData
import com.usman.mvvmsample.apicalls.ServiceGateway
import com.usman.mvvmsample.backend.NetworkHelper
import com.usman.mvvmsample.core.BaseResponse
import com.usman.mvvmsample.features.model.Album
import com.usman.mvvmsample.features.model.AlbumDAO
import io.reactivex.Completable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by Muhammad Usman on 2/1/2019.
 */

@Singleton
class AlbumRepo @Inject constructor(private val serviceGateway: ServiceGateway,
                                    private val dao: AlbumDAO,
                                    private val networkHelper: NetworkHelper) {

    private val liveAlbum = MediatorLiveData<BaseResponse<List<Album>>>()

    fun getLiveAlbums(): LiveData<BaseResponse<List<Album>>> {

        val dbSource = dao.getAll()
        liveAlbum.addSource(dbSource) { albums ->
            if (!albums.isNullOrEmpty()) {
                liveAlbum.value = BaseResponse.success(albums)
            } else {
                fetchFromNetwork()
            }
        }

        return liveAlbum
    }

    private fun fetchFromNetwork() {

        val networkSource = networkHelper.serviceCall(serviceGateway.getAlbums())

        liveAlbum.addSource(networkSource) { response ->
            response?.data?.let {
                liveAlbum.removeSource(networkSource)
                Completable.fromCallable { dao.insert(*it.toTypedArray()) }
                        .subscribeOn(Schedulers.newThread())
                        .subscribe()
            } ?: kotlin.run {
                liveAlbum.value = response
            }

        }
    }

//    private fun loadFromDb() = database.getSortedRecords<Album>("title")


}
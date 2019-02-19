package com.usman.mvvmsample

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.Observer
import com.usman.mvvmsample.apicalls.ServiceGateway
import com.usman.mvvmsample.backend.NetworkHelper
import com.usman.mvvmsample.core.BaseResponse
import com.usman.mvvmsample.features.model.Album
import com.usman.mvvmsample.features.repository.AlbumRepo
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Test
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.MockitoAnnotations

/**
 * Created by Muhammad Usman on 2/1/2019.
 */

class AlbumRepoTest {

    @InjectMocks
    lateinit var albumRepo: AlbumRepo

    @Mock
    lateinit var serviceGateway: ServiceGateway


    @Mock
    lateinit var networkHelper: NetworkHelper


    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)
    }

    @Test
    fun getImagesFromDatabaseSuccessTest() {

//        val liveData = MutableLiveData<BaseResponse<List<Album>>>()
//        `when`(networkHelper.serviceCall(serviceGateway.getAlbums())).thenReturn(liveData)
//
//        val albumsLiveData = MutableLiveData<List<Album>>()
//        `when`(database.getSortedRecords<Album>("title")).thenReturn(albumsLiveData)
//
//        val observer = mock(Observer::class.java) as Observer<BaseResponse<List<Album>>>
//
//        val data  = albumRepo.getLiveAlbums()
//        verify(database).getSortedRecords<Album>("title")
//
//        data.observeForever(observer)
//
//        verifyNoMoreInteractions(serviceGateway)
//
//        val updatedDbData = MutableLiveData<List<Album>>()
//        `when`(database.getSortedRecords<Album>("title")).thenReturn(updatedDbData)
//
//        verify(networkHelper).serviceCall(serviceGateway.getAlbums())
//
//        verify(observer).onChanged(BaseResponse.loading(null))
//
//        assertNotNull(updatedDbData.value)
//        verify(database).saveList(updatedDbData.value!!)
//
//        verify(observer).onChanged(BaseResponse.success(mutableListOf<Album>()))


    }

}
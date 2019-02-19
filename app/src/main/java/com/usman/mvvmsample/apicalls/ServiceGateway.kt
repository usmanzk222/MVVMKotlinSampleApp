package com.usman.mvvmsample.apicalls

import com.usman.mvvmsample.features.model.Album
import io.reactivex.Single
import retrofit2.Response
import retrofit2.http.GET


interface ServiceGateway {

    @GET("albums")
    fun getAlbums(): Single<Response<List<Album>>>
}

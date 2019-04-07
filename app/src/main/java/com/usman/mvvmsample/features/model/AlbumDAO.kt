package com.usman.mvvmsample.features.model

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.*
import com.usman.mvvmsample.persistence.BaseDAO
import io.reactivex.Completable

/**
 * Created by Muhammad Usman on 2/15/2019.
 */

@Dao
interface AlbumDAO :BaseDAO<Album> {

    @Query("SELECT * FROM albums ORDER BY title ASC")
    fun getAll(): LiveData<List<Album>>

    @Query("SELECT * FROM albums WHERE id = :album_id")
    fun getMovie(album_id: Int): LiveData<Album>

    @Query("DELETE FROM albums")
    fun deleteAll()
}
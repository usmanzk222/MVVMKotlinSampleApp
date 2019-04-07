package com.usman.mvvmsample.features.model

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import com.usman.mvvmsample.persistence.BaseDAO

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
package com.usman.mvvmsample.features.model

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.*
import io.reactivex.Completable

/**
 * Created by Muhammad Usman on 2/15/2019.
 */

@Dao
interface AlbumDAO {

    @Query("SELECT * FROM albums ORDER BY title ASC")
    fun getAll(): LiveData<List<Album>>

    @Query("SELECT * FROM albums WHERE id = :album_id")
    fun getMovie(album_id: Int): LiveData<Album>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(albums: List<Album>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(vararg album: Album)

    @Delete
    fun delete(vararg album: Album)

    @Update
    fun update(vararg album: Album)

    @Query("DELETE FROM albums")
    fun deleteAll()
}
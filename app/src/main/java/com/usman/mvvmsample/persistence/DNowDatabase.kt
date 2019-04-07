package com.usman.mvvmsample.persistence

import androidx.room.Database
import androidx.room.RoomDatabase
import com.usman.mvvmsample.features.model.Album
import com.usman.mvvmsample.features.model.AlbumDAO

/**
 * Created by Muhammad Usman on 2/15/2019.
 */

@Database(entities = [Album::class], version = 1, exportSchema = false)
abstract class DNowDatabase: RoomDatabase() {

    abstract fun getAlbumDao(): AlbumDAO
}
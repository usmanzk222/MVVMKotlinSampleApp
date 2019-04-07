package com.usman.mvvmsample.persistence

import android.arch.persistence.room.Delete
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Update

/**
 * Created by Muhammad Usman on 3/8/2019.
 */
interface BaseDAO <EN> {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(entity: List<EN>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(vararg entity: EN)

    @Delete
    fun delete(vararg entity: EN)

    @Update
    fun update(vararg entity: EN)
}
package com.usman.mvvmsample.features.model

import androidx.room.Entity
import androidx.room.PrimaryKey


/**
 * Created by Muhammad Usman on 1/31/2019.
 */

@Entity(tableName = "albums")
open class Album {
    var userId: Int = -1
    @PrimaryKey
    var id: Int = -1
    var title: String = ""
}
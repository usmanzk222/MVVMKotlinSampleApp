package com.usman.mvvmsample.dagger.module

import android.app.Application
import android.arch.persistence.room.Room
import android.content.Context
import android.content.SharedPreferences
import com.usman.mvvmsample.MVVMApplication
import com.usman.mvvmsample.features.model.AlbumDAO
import com.usman.mvvmsample.persistence.DNowDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by Muhammad Usman on 1/31/2019.
 */

@Module(includes = [ViewModelModule::class])
class AppModule {

    @Provides
    @Singleton
    fun provideApplicationContext(application: MVVMApplication): Context {
        return application.applicationContext
    }

    @Provides
    @Singleton
    fun provideApplication(application: MVVMApplication): Application {
        return application
    }

    @Provides
    @Singleton
    fun provideSharedPreferences(context: Context): SharedPreferences {
        return context.getSharedPreferences(context.packageName, Context.MODE_PRIVATE)
    }


    @Singleton
    @Provides
    fun provideDb(application: Application): DNowDatabase {
        return Room.databaseBuilder(application, DNowDatabase::class.java, "dnow-db").build()

    }

    @Singleton
    @Provides
    fun provideMoviesDao(database: DNowDatabase): AlbumDAO {
        return database.getAlbumDao()
    }

}

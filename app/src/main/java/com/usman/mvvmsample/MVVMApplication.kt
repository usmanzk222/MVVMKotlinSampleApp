package com.usman.mvvmsample

import com.usman.mvvmsample.dagger.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

/**
 * Created by Muhammad Usman on 1/31/2019.
 */
class MVVMApplication: DaggerApplication() {

    companion object {
        private lateinit var sInstance: MVVMApplication
        fun getInstance(): MVVMApplication {
            return sInstance
        }
    }

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerAppComponent
                .builder()
                .create(this)
    }

    override fun onCreate() {
        super.onCreate()
        sInstance = this
    }
}
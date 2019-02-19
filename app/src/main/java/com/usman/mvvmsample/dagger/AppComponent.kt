package com.usman.mvvmsample.dagger

import com.usman.mvvmsample.MVVMApplication
import com.usman.mvvmsample.dagger.module.ActivityBuilder
import com.usman.mvvmsample.dagger.module.AppModule
import com.usman.mvvmsample.dagger.module.NetworkModule
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

/**
 * Created by Muhammad Usman on 1/31/2019.
 */

@Singleton
@Component(modules = [AppModule::class,
    AndroidSupportInjectionModule::class,
    NetworkModule::class, ActivityBuilder::class])

interface AppComponent : AndroidInjector<MVVMApplication> {
    @Component.Builder
    abstract class Builder : AndroidInjector.Builder<MVVMApplication>()
}

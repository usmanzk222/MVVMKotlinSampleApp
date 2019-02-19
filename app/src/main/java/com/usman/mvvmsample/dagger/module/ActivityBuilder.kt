package com.usman.mvvmsample.dagger.module

import com.usman.mvvmsample.features.AlbumsActivity
import com.usman.mvvmsample.dagger.annotations.ActivityScope
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by Muhammad Usman on 01/31/2019.
 */

@Module
abstract class ActivityBuilder {

    @ActivityScope
    @ContributesAndroidInjector(modules = [(FragmentBuilder::class)])
    internal abstract fun bindAlbumActivity(): AlbumsActivity
}

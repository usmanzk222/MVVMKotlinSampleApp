package com.usman.mvvmsample.dagger.module

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.usman.mvvmsample.dagger.ViewModelFactory
import com.usman.mvvmsample.dagger.annotations.ViewModelKey
import com.usman.mvvmsample.features.viewmodel.AlbumsViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

/**
 * Created by Muhammad Usman on 11/15/2018.
 */

@Module
abstract class ViewModelModule {

    @Binds
    internal abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(AlbumsViewModel::class)
    internal abstract fun mainViewModel(viewModel: AlbumsViewModel): ViewModel

}
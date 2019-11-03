package com.aryansa.rizqi.loremipsum.di.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.aryansa.rizqi.loremipsum.di.component.ViewModelKey
import com.aryansa.rizqi.loremipsum.factory.ViewModelFactory
import com.aryansa.rizqi.loremipsum.presentation.viewmodels.LoremViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
internal abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(LoremViewModel::class)
    internal abstract fun bindLoremViewModels(loremViewModel: LoremViewModel): ViewModel

    @Binds
    internal abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory
}
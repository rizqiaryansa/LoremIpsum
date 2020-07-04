package com.aryansa.rizqi.loremipsum.di.module

import com.aryansa.rizqi.loremipsum.data.source.remote.LoremService
import com.aryansa.rizqi.loremipsum.data.repository.LoremRepository
import com.aryansa.rizqi.loremipsum.data.repository.LoremRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
class RepositoryModule {

    @Provides
    @Singleton
    fun provideLoremRepository(apiService: LoremService): LoremRepository =
        LoremRepositoryImpl(
            apiService
        )

}
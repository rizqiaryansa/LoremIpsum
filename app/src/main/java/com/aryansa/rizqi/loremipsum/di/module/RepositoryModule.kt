package com.aryansa.rizqi.loremipsum.di.module

import com.aryansa.rizqi.loremipsum.data.source.remote.LoremService
import com.aryansa.rizqi.loremipsum.repository.LoremRepository
import com.aryansa.rizqi.loremipsum.repository.LoremRepositoryImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Provides
    @Singleton
    fun provideLoremRepository(apiService: LoremService): LoremRepository = LoremRepositoryImpl(apiService)

}
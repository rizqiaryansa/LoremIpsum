package com.aryansa.rizqi.loremipsum.di.component

import com.aryansa.rizqi.loremipsum.presentation.view.activity.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilder {

    @ContributesAndroidInjector
    abstract fun contributeMainActivity(): MainActivity
}
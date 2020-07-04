package com.aryansa.rizqi.loremipsum.common.base

import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable

abstract class BaseViewModel : ViewModel() {

    protected val disposable by lazy { CompositeDisposable() }

    override fun onCleared() {
        super.onCleared()
        disposable.clear()
    }
}
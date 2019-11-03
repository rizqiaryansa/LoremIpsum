package com.aryansa.rizqi.loremipsum.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable

abstract class BaseViewModel : ViewModel() {

    protected val disposable by lazy { CompositeDisposable() }

    private val _loadingState = MutableLiveData<Boolean>()
    val loadingState = _loadingState

    override fun onCleared() {
        super.onCleared()
        disposable.clear()
    }

    fun setIsLoading(boolean: Boolean) {
        _loadingState.postValue(boolean)
    }
}
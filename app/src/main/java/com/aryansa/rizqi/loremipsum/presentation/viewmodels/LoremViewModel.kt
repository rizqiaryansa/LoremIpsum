package com.aryansa.rizqi.loremipsum.presentation.viewmodels

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.aryansa.rizqi.loremipsum.common.base.BaseViewModel
import com.aryansa.rizqi.loremipsum.data.repository.LoremRepository
import com.aryansa.rizqi.loremipsum.common.utils.ResultResponse
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class LoremViewModel @ViewModelInject
constructor(private val repository: LoremRepository): BaseViewModel() {

    private val _state = MutableLiveData<ResultResponse>()
    val state : LiveData<ResultResponse> = _state

    fun getLorem() {
        disposable.add(repository.fetchLorem().subscribeOn(
            Schedulers.io()
        ).observeOn(
            AndroidSchedulers.mainThread()
        ).subscribe({
            _state.postValue(
                ResultResponse.Success(it)
            )
        }, {
            _state.postValue(ResultResponse.Failure(it))
        }))
    }
}
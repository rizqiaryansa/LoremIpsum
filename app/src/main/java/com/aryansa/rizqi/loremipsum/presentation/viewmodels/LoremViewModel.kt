package com.aryansa.rizqi.loremipsum.presentation.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.aryansa.rizqi.loremipsum.base.BaseViewModel
import com.aryansa.rizqi.loremipsum.domain.model.remote.LoremIpSumResponse
import com.aryansa.rizqi.loremipsum.repository.LoremRepository
import com.aryansa.rizqi.loremipsum.utils.ResultResponse
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class LoremViewModel @Inject
constructor(private val repository: LoremRepository): BaseViewModel() {

    private val _state = MutableLiveData<ResultResponse>()
    val state : LiveData<ResultResponse> = _state

    fun getLorem() {
        disposable.add(repository.fetchLorem().doOnSubscribe {
            setIsLoading(true)
        }.doAfterTerminate {
            setIsLoading(false)
        }.subscribeOn(
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
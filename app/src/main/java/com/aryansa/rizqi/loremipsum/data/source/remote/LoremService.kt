package com.aryansa.rizqi.loremipsum.data.source.remote

import com.aryansa.rizqi.loremipsum.domain.model.remote.LoremIpSumResponse
import io.reactivex.Single
import retrofit2.http.GET

interface LoremService {

    @GET("0c274f3314cefd40f66e6ed83f08acc6/raw/8b0c6eb6a95cde6db904f5a0eddba280aef96680/ListData.json")
    fun getLorem(): Single<LoremIpSumResponse>
}
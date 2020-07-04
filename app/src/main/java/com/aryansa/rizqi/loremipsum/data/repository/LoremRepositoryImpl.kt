package com.aryansa.rizqi.loremipsum.data.repository

import com.aryansa.rizqi.loremipsum.domain.model.remote.LoremIpSumResponse
import com.aryansa.rizqi.loremipsum.data.source.remote.LoremService
import io.reactivex.Single
import javax.inject.Inject

interface LoremRepository {
    fun fetchLorem(): Single<LoremIpSumResponse>
}

class LoremRepositoryImpl @Inject
constructor(private val service: LoremService):
    LoremRepository {

    override fun fetchLorem(): Single<LoremIpSumResponse> {
        return service.getLorem()
    }
}



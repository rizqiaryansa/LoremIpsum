package com.aryansa.rizqi.loremipsum.common.utils

import com.aryansa.rizqi.loremipsum.domain.model.remote.LoremIpSumResponse

sealed class ResultResponse {
    data class Success(val responseData: LoremIpSumResponse?): ResultResponse()
    data class Failure(val throwable: Throwable): ResultResponse()
}
package com.aryansa.rizqi.loremipsum.domain.model.remote

import com.google.gson.annotations.SerializedName

data class LoremIpSumResponse(
    @SerializedName("data")
    val data: List<Data>,
    @SerializedName("status_code")
    val statusCode: Int? = 0
) {
    data class Data(
        @SerializedName("content")
        val content: String? = "",
        @SerializedName("id")
        val id: Int? = 0,
        @SerializedName("media")
        val media: List<String>? = listOf(),
        @SerializedName("title")
        val title: String? = "",
        @SerializedName("type")
        var type: String? = ""
    )
}
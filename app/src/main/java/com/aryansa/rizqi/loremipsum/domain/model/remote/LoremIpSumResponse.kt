package com.aryansa.rizqi.loremipsum.domain.model.remote


import com.google.gson.annotations.SerializedName

data class LoremIpSumResponse(
    @SerializedName("data")
    val data: List<Data>,
    @SerializedName("status_code")
    val statusCode: Int
)

data class Data(
    @SerializedName("content")
    val content: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("media")
    val media: List<String>,
    @SerializedName("title")
    val title: String,
    @SerializedName("type")
    var type: String
)
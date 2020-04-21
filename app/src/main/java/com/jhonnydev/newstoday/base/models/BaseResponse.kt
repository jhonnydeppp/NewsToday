package com.jhonnydev.newstoday.base.models

import com.google.gson.annotations.SerializedName

data class BaseResponse<T> (

    @field:SerializedName("articles")
    val data: T? = null,

    @field:SerializedName("totalResults")
    val message: Int? = null,

    @field:SerializedName("status")
    val status: Boolean? = null

)
package com.hostienda.betting.base.models

import com.google.gson.annotations.SerializedName


    data class BaseResponseList<T>(

        @field:SerializedName("articles")
        val data: MutableList<T>? = null,

        @field:SerializedName("totalResults")
        val message: Int? = null,

        @field:SerializedName("status")
        val status: Boolean? = null
    )



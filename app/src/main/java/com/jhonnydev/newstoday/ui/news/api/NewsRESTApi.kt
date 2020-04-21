package com.jhonnydev.newstoday.ui.news.api

import com.jhonnydev.newstoday.base.models.BaseResponse
import com.jhonnydev.newstoday.ui.news.models.ActiclesResponse
import io.reactivex.Observable
import retrofit2.http.*

interface NewsRESTApi {

    @Headers("Content-Type:application/json", "Accept:application/json")
    @GET("everything")
    fun news(@Query("apiKey")  apiKey: String,
             @Query("sortBy")  sortBy: String,
             @Query("q")  q: String,
             @Query("from")  from: String): Observable<BaseResponse<List<ActiclesResponse>>>
//?{apiKey}?{sortBy}?{q}?{from}

}
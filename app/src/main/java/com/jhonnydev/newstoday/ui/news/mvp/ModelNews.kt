package com.jhonnydev.newstoday.ui.news.mvp
import com.jhonnydev.newstoday.base.RetrofitClient
import com.jhonnydev.newstoday.ui.news.api.NewsRESTApi
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class ModelNews{

    val API = RetrofitClient.getClient().create(NewsRESTApi::class.java)

    fun getNews(apiKey :String,sortBy :String,q :String, from :String) = API.news(apiKey ,sortBy ,q , from ).
    subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())!!

}
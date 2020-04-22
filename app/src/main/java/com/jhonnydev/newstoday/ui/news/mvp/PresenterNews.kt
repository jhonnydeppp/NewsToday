package com.jhonnydev.newstoday.ui.news.mvp

import android.annotation.SuppressLint
import android.util.Log
import com.jhonnydev.newstoday.R

import com.jhonnydev.newstoday.base.models.BaseResponse
import com.jhonnydev.newstoday.base.observer.CallbackHandlingObserver
import com.jhonnydev.newstoday.ui.news.models.ArticlesResponse

class PresenterNews(private var view: ContractNews.View?): ContractNews.Presenter {

    private val model = ModelNews()
    private val ENDPOINT_NEWS = "ENDPOINT_NEWS"
    private val TAG = PresenterNews::class.java.simpleName

    @SuppressLint("CheckResult")
    override fun getNews() {
        view!!.showProgress(true)
        model.getNews("1c3c18c7f22c49d69e8223c369b1042a","publishedAt","bitcoin","2020-04-21")
            .subscribeWith(object : CallbackHandlingObserver<BaseResponse<List<ArticlesResponse>>>(this, ENDPOINT_NEWS) {
                override fun onSuccess(data: BaseResponse<List<ArticlesResponse>>) {
                    view?.showProgress(false)
                    view?.showArticles(data.data!!)
                    Log.i(TAG,"consulta exitosa ")
                }

            })
    }

    override fun destroyView() {
      view = null
    }

    override fun onUnknownError(error: String, caller: String) {
      Log.e(TAG,"onUnknownError error $error  caller --> $caller")
        genericError()
    }

    override fun onTimeoutError(caller: String) {
        Log.i(TAG,"error: caller--> $caller")
        genericError(R.string.error_timeout)
    }

    override fun onNetworkError(caller: String) {
        Log.i(TAG,"error: caller--> $caller")
        genericError(R.string.error_network)
    }

    override fun onBadRequestError(caller: String, codeError: Int) {
        Log.i(TAG,"error: caller--> $caller")
        genericError(R.string.error_badrequest)
    }

    override fun onServerError(caller: String) {
        Log.i(TAG,"error: caller--> $caller")
        genericError(R.string.error_server)
    }

    override fun infoError(cause: Throwable?, msg: String?) {
        Log.i(TAG,"error: $msg, Cause: ${cause.toString()}")

    }

    private fun genericError(msg:Int = R.string.error_unknown){
        view?.showProgress(false)
        view?.makeToast(msg)
    }




}





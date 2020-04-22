package com.jhonnydev.newstoday.ui.news.mvp

import com.jhonnydev.newstoday.base.mvp.BaseContract
import com.jhonnydev.newstoday.ui.news.models.ArticlesResponse

interface ContractNews {
    //Presentador
    interface Presenter: BaseContract.ServicePresenter{

        fun getNews()


    }
    //VIEWs
    interface View: BaseContract.View{
        fun showArticles( articles : List<ArticlesResponse>)
    }


}
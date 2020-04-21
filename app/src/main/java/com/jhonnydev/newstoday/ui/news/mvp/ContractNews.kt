package com.jhonnydev.newstoday.ui.news.mvp

import com.jhonnydev.newstoday.base.mvp.BaseContract

interface ContractNews {
    //Presentador
    interface Presenter: BaseContract.ServicePresenter{

        fun getNews()


    }
    //VIEWs
    interface View: BaseContract.View{
    }


}
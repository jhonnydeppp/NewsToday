package com.hostienda.betting.base.mvp

interface BaseContract {


    /**
     * Here is the ContractLoginModul from the view to presenter.
     * Here you set any method from VIEW available to PresenterLoginModule.
     */
    interface View {
        fun showProgress(isShow: Boolean)
        fun makeToast(msg:Int)
    }
    /**
     * Here is the ContractLoginModul from the PresenterLoginModule to the View.
     * Here you set any methods from PRESENTER available to View.
     */
    interface Presenter{

        fun destroyView()

    }
    /**
     * Este es el contrato del Presentador a la Vista, el cual se va a encargar de recibir la respuesta de servicios web.
     */

    interface ServicePresenter:BaseContract.Presenter{
         fun onUnknownError(error: String, caller: String)

         fun onTimeoutError(caller: String)

         fun onNetworkError(caller: String)

         fun onBadRequestError(caller: String, codeError: Int)

         fun onServerError(caller: String)

         fun infoError(cause: Throwable?, msg: String?)

    }



}
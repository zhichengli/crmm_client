package com.zcl.crmm_client.login.mvp

import com.zcl.crmm_client.login.bean.User
import com.zcl.crmm_client.mvp_base.BasePresenter
import com.zcl.crmm_client.mvp_base.IPresenter
import com.zcl.crmm_client.mvp_base.IView

interface LoginContract {
    interface ILoginView:IView{
        fun loginSuccess()
    }
    abstract class ILoginPresenter<T:IView>: BasePresenter<T>(){
        abstract fun login(user:User)
    }
}
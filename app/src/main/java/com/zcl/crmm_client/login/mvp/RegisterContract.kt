package com.zcl.crmm_client.login.mvp

import com.zcl.crmm_client.login.bean.User
import com.zcl.crmm_client.mvp_base.BasePresenter
import com.zcl.crmm_client.mvp_base.IPresenter
import com.zcl.crmm_client.mvp_base.IView

interface RegisterContract {
    interface IRegisterView: IView {}
    abstract class IRegisterPresenter<T: IView>: BasePresenter<T>() {
        abstract fun sendSMS(phone:String)
        abstract fun registerUser(code:String,user: User)
    }
}
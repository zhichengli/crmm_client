package com.zcl.crmm_client.login.mvp

import com.zcl.crmm_client.base.API
import com.zcl.crmm_client.base.RestAPI
import com.zcl.crmm_client.login.bean.User
import com.zcl.crmm_client.mvp_base.BasePresenter
import com.zcl.crmm_client.mvp_base.IView

class LoginPresenter<T:IView>: LoginContract.ILoginPresenter<T>() {
    override fun login(user: User) {
        API.login(user).enqueue(mCallback {
            var token = it["token"].toString()
            mRootView?.onSuccess(token)
        })
    }
}
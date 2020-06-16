package com.zcl.crmm_client.login.mvp

import com.fasterxml.jackson.databind.ObjectMapper
import com.zcl.crmm_client.base.API
import com.zcl.crmm_client.base.BaseApplication
import com.zcl.crmm_client.base.RestAPI
import com.zcl.crmm_client.constant.SP
import com.zcl.crmm_client.login.LoginActivity
import com.zcl.crmm_client.login.bean.User
import com.zcl.crmm_client.mvp_base.BasePresenter
import com.zcl.crmm_client.mvp_base.IView

class LoginPresenter<T:IView>: LoginContract.ILoginPresenter<T>() {
    lateinit var act:LoginActivity

    override fun attachView(view: T) {
        super.attachView(view)
        act = mRootView as LoginActivity
    }

    override fun login(user: User) {
        API.login(user).enqueue(mCallback {
            var token = it["token"].toString()
            var user = ObjectMapper().readValue(it["user"].toString(),User::class.java)
            SP.token = token
            SP.user = user
            BaseApplication.user = user
            mRootView?.onSuccess("登录成功")
            act.loginSuccess()
        })
    }

}
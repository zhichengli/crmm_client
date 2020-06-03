package com.zcl.crmm_client.login.mvp

import android.util.Log
import com.zcl.crmm_client.base.API
import com.zcl.crmm_client.base.RestAPI
import com.zcl.crmm_client.constant.StatusCode
import com.zcl.crmm_client.login.bean.User
import com.zcl.crmm_client.mvp_base.IView
import com.zcl.crmm_client.utils.ToastUtils
import retrofit2.Call
import retrofit2.Response

class RegisterPresenter<T:IView>: RegisterContract.IRegisterPresenter<T>() {

    override fun onStart() {
        super.onStart()
    }
    override fun sendSMS(phone: String) {
        mRootView?.showLoading()
        API.sendSMS(phone).enqueue(mCallback {
            mRootView?.onSuccess("获取验证码成功")
        })
    }

    override fun registerUser(code: String, user: User) {
        API.register(code,user).enqueue(mCallback {
            var result = it as RestAPI.Result<Any>
            if(result.code == StatusCode.OK){
                mRootView?.onSuccess(result.message)
            }else{
                mRootView?.onFail(result.message)
            }
        })
    }

}
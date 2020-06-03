package com.zcl.crmm_client.mvp_base

/**
 *Created by zcl
 *
 */
interface IView {
    fun showLoading()
    fun hideLoading()

    fun onSuccess(msg:String)
    //统一处理错误消息

    fun onFail(msg: String)
    fun onError(e : Exception)
}
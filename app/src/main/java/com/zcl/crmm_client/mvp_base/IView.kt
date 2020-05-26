package com.zcl.crmm_client.mvp_base

/**
 *Created by zcl
 *
 */
interface IView {
    fun showLoading()
    fun hideLoading()
    fun <T> showMsg(msg:T)
    //统一处理错误消息
    fun errorMsg(e : Exception)
}
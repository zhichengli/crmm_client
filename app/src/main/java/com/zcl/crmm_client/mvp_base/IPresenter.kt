package com.zcl.crmm_client.mvp_base

/**
 *Created by zcl
 *
 */
interface IPresenter<T : IView> {
    fun onStart()//初始化操作
    fun onDestroy() //销毁
    fun attachView(view: T)
}
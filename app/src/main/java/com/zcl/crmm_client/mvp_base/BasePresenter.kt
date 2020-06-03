package com.zcl.crmm_client.mvp_base

import com.zcl.crmm_client.base.BaseActivity
import com.zcl.crmm_client.base.Callback

/**
 *Created by zcl
 *
 */
abstract class BasePresenter<V : IView> : IPresenter<V> {
    var mRootView: V?=null

    constructor() {
        onStart()
    }

    override fun onStart() {

    }

    override fun onDestroy() {
        mRootView = null
    }

     override fun attachView(view: V) {
        mRootView = view
    }
    fun <T> mCallback(callback:(T)->Unit) = Callback(mRootView as BaseActivity,callback = callback)
}
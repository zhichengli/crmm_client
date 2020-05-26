package com.zcl.crmm_client.mvp_base

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

    override fun getView(): V {
        return mRootView!!
    }

}
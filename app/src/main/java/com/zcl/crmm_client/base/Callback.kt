package com.zcl.crmm_client.base

import android.content.Context
import com.zcl.crmm_client.utils.ToastUtils
import retrofit2.Call
import retrofit2.Response

class Callback<T> : retrofit2.Callback<RestAPI.Result<T>> {
    private val callback: (T) -> Unit
    private val rootView:BaseActivity
    constructor(rootView:Context,callback: (T) -> Unit){
        this.callback = callback
        this.rootView = rootView as BaseActivity
        rootView.showLoading()
    }

    override fun onFailure(call: Call<RestAPI.Result<T>>, t: Throwable) {
        ToastUtils.shortShow("访问失败了")
        rootView.hideLoading()
    }

    override fun onResponse(call: Call<RestAPI.Result<T>>, response: Response<RestAPI.Result<T>>) {
        try {
            val result = response.body() as RestAPI.Result<T>
            callback(result.data as T)
        }catch (e:Exception){
            e.printStackTrace()
            onFailure(call,e)
        }finally {
            rootView.hideLoading()
        }
    }

}
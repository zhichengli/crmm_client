package com.zcl.crmm_client.base


import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import com.zcl.crmm_client.R
import com.zcl.crmm_client.constant.StatusCode
import com.zcl.crmm_client.mvp_base.IView
import com.zcl.crmm_client.utils.StatusBarUtil
import com.zcl.crmm_client.utils.ToastUtils
import com.zcl.crmm_client.view.LoadingDialog
import retrofit2.Call
import retrofit2.Response

/**
 *Created by zcl
 *
 */
abstract class BaseActivity : AppCompatActivity(), IView {

    lateinit var loadingDialog: LoadingDialog
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //沉浸式代码配置
        //当FitsSystemWindows设置 true 时，会在屏幕最上方预留出状态栏高度的 padding
        StatusBarUtil.setRootViewFitsSystemWindows(this, true);
        //设置状态栏透明
        StatusBarUtil.setTranslucentStatus(this);
        //一般的手机的状态栏文字和图标都是白色的, 可如果你的应用也是纯白色的, 或导致状态栏文字看不清
        //所以如果你是这种情况,请使用以下代码, 设置状态使用深色文字图标风格, 否则你可以选择性注释掉这个if内容
        if (!StatusBarUtil.setStatusBarDarkTheme(this, true)) {
            //如果不支持设置深色风格 为了兼容总不能让状态栏白白的看不清, 于是设置一个状态栏颜色为半透明,
            //这样半透明+白=灰, 状态栏的文字能看得清
            StatusBarUtil.setStatusBarColor(this, 0x55000000);
        }
        loadingDialog = LoadingDialog(this)
    }

    override fun onRestart() {
        super.onRestart()
    }

    override fun onResume() {
        super.onResume()
    }

    override fun onDestroy() {
        super.onDestroy()
    }

    override fun showLoading() {
        loadingDialog.showDialog()
    }

    override fun hideLoading() {
        loadingDialog.dismissDialog()
    }

    override fun onError(e: Exception) {

    }

    override fun onSuccess(msg: String) {
        ToastUtils.shortShow(msg)
    }

    override fun onFail(msg: String) {
        ToastUtils.shortShow(msg)
    }
/*
    fun <T> mCallback(callback:(T)->Unit) = Callback(callback = callback)

    inner class Callback<T> : retrofit2.Callback<RestAPI.Result<T>> {
        private val callback: (T) -> Unit

        constructor(callback: (T) -> Unit){
            this.callback = callback
            showLoading()
        }

        override fun onFailure(call: Call<RestAPI.Result<T>>, t: Throwable) {
            ToastUtils.shortShow("访问失败了")
        }

        override fun onResponse(call: Call<RestAPI.Result<T>>, response: Response<RestAPI.Result<T>>) {
            try {
                val result = response.body() as RestAPI.Result<T>
                callback(result as T)
            }catch (e:Exception){
                e.printStackTrace()
                onFailure(call,e)
            }finally {
                hideLoading()
            }
        }

    }*/

}

































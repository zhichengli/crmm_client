package com.zcl.crmm_client.base


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.zcl.crmm_client.mvp_base.BasePresenter
import com.zcl.crmm_client.mvp_base.IPresenter
import com.zcl.crmm_client.mvp_base.IView

/**
 *Created by zcl
 *
 */
abstract class BaseActivity : AppCompatActivity() , IView {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
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

    }

    override fun hideLoading() {

    }

    override fun <T> showMsg(msg: T) {

    }

    override fun errorMsg(e: Exception) {

    }


}
package com.zcl.crmm_client.base

import androidx.fragment.app.Fragment
import com.zcl.crmm_client.mvp_base.IView

open class BaseFragment : Fragment(), IView {




    override fun showLoading() {

    }

    override fun hideLoading() {

    }

    override fun onSuccess(msg: String) {
    }

    override fun onFail(msg: String) {
    }

    override fun onError(e: Exception) {
    }
}
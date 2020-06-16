package com.zcl.crmm_client.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.zcl.crmm_client.R
import com.zcl.crmm_client.base.BaseFragment

class HomeFragment : BaseFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var view = inflater.inflate(R.layout.fragment_home_main,container,false)
        initView(view)
        return view
    }

    private fun initView(view: View ) {

    }
}
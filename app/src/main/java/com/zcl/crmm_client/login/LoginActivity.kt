package com.zcl.crmm_client.login

import android.content.Intent
import android.os.Bundle
import android.util.Log
import com.zcl.crmm_client.MainActivity
import com.zcl.crmm_client.R
import com.zcl.crmm_client.base.API
import com.zcl.crmm_client.base.BaseActivity
import com.zcl.crmm_client.base.RestAPI
import retrofit2.Call
import retrofit2.Response

/**
 *Created by zcl
 *
 */
class LoginActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        API.sendSMS("13717509165").enqueue(object : retrofit2.Callback<RestAPI.Result<Any>> {
            override fun onFailure(call: Call<RestAPI.Result<Any>>, t: Throwable) {
                Log.d("code","failure")
            }

            override fun onResponse(
                call: Call<RestAPI.Result<Any>>,
                response: Response<RestAPI.Result<Any>>
            ) {

                Log.d("code", response.body().toString())
            }

        })
    }
}
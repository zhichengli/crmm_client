package com.zcl.crmm_client.login

import android.content.Intent
import android.os.Bundle
import android.text.method.PasswordTransformationMethod
import android.util.Log
import android.widget.Toast
import com.zcl.crmm_client.MainActivity
import com.zcl.crmm_client.R
import com.zcl.crmm_client.base.API
import com.zcl.crmm_client.base.BaseActivity
import com.zcl.crmm_client.base.RestAPI
import com.zcl.crmm_client.utils.ToastUtils
import kotlinx.android.synthetic.main.activity_login.*
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

        initView()


    }

    private fun initView() {
        et_phone.setOnFocusChangeListener { view, b ->
            v_phone_line.isSelected = b
        }

        et_password.setOnFocusChangeListener { view, b ->
            v_password_line.isSelected = b
        }

        iv_clear.setOnClickListener {
            et_phone.text = null
            et_password.text = null
        }
        iv_show_password.setOnClickListener {
            it.isSelected = it.isSelected.not()
            et_password.transformationMethod = if (it.isSelected) null else PasswordTransformationMethod.getInstance()
        }

        btn_login.setOnClickListener {
            if(et_phone.text.toString().isNullOrBlank()) return@setOnClickListener ToastUtils.shortShow("请输入手机号")
            if(et_password.text.toString().isNullOrBlank()) return@setOnClickListener ToastUtils.shortShow("请输入密码")

            //todo 调取接口
        }

        tv_go_register.setOnClickListener {
            //todo 跳往注册页面
            startActivity(Intent(this,RegisterActivity::class.java))
        }

        tv_go_find.setOnClickListener {
            //todo 跳往找回密码页面
        }
    }
}

/**
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
        */
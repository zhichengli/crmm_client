package com.zcl.crmm_client.login

import android.os.Bundle
import android.text.method.PasswordTransformationMethod
import com.zcl.crmm_client.R
import com.zcl.crmm_client.base.BaseActivity
import com.zcl.crmm_client.login.bean.User
import com.zcl.crmm_client.login.mvp.RegisterPresenter
import com.zcl.crmm_client.utils.ToastUtils
import kotlinx.android.synthetic.main.activity_register.*

/**
 *Created by zcl
 *
 */
class RegisterActivity : BaseActivity() {
    lateinit var mPresenter:RegisterPresenter<BaseActivity>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        initPresenter()
        initView()
    }

    private fun initPresenter() {
        mPresenter = RegisterPresenter()
        mPresenter.attachView(this)
    }

    private fun initView() {
        et_phone.setOnFocusChangeListener { view, b ->
            v_phone_line.isSelected = b
        }
        et_auth_code.setOnFocusChangeListener{view, b ->
            v_auth_code_line.isSelected = b
        }

        et_password.setOnFocusChangeListener { view, b ->
            v_password_line.isSelected = b
        }

        et_confirm_password.setOnFocusChangeListener { view, b ->
            v_confirm_password_line.isSelected = b
        }

        iv_clear.setOnClickListener {
            et_phone.text = null
            et_auth_code.text = null
            et_password.text = null
            et_confirm_password.text = null
        }

        iv_auth_code.setOnClickListener {
            if(et_phone.text.isNullOrBlank()) ToastUtils.shortShow("请输入手机号")
            mPresenter.sendSMS(et_phone.text.toString())
        }
        btn_login.setOnClickListener {
            mPresenter.registerUser(et_auth_code.text.toString(), User(mobile=et_phone.text.toString(),password = et_password.text.toString()))
        }

        iv_show_password.setOnClickListener {
            it.isSelected = it.isSelected.not()

            if (it.isSelected) iv_show_password.setImageResource(R.mipmap.login_pwd_show) else iv_show_password.setImageResource(
                R.mipmap.login_pwd_hide
            )
            et_password.transformationMethod =
                if (it.isSelected) null else PasswordTransformationMethod.getInstance()
        }

        iv_show_confirm_password.setOnClickListener {
            it.isSelected = it.isSelected.not()

            if (it.isSelected) iv_show_confirm_password.setImageResource(R.mipmap.login_pwd_show) else iv_show_confirm_password.setImageResource(
                R.mipmap.login_pwd_hide
            )
            et_confirm_password.transformationMethod =
                if (it.isSelected) null else PasswordTransformationMethod.getInstance()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        mPresenter.onDestroy()
    }
}
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
import com.zcl.crmm_client.login.bean.User
import com.zcl.crmm_client.login.mvp.LoginContract
import com.zcl.crmm_client.login.mvp.LoginPresenter
import com.zcl.crmm_client.utils.StatusBarUtil
import com.zcl.crmm_client.utils.ToastUtils
import kotlinx.android.synthetic.main.activity_login.*
import retrofit2.Call
import retrofit2.Response


/**
 *Created by zcl
 *
 */
class LoginActivity : BaseActivity(), LoginContract.ILoginView {
lateinit var mPresenter:LoginPresenter<BaseActivity>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        initPresenter()
        initView()

        //用来设置整体下移，状态栏沉浸
        StatusBarUtil.setRootViewFitsSystemWindows(this, false);
    }

    private fun initPresenter() {
        mPresenter = LoginPresenter()
        mPresenter.attachView(this)
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

            if(it.isSelected) iv_show_password.setImageResource(R.mipmap.login_pwd_show) else iv_show_password.setImageResource(R.mipmap.login_pwd_hide)
            et_password.transformationMethod = if (it.isSelected) null else PasswordTransformationMethod.getInstance()
        }

        btn_login.setOnClickListener {
            if(et_phone.text.toString().isNullOrBlank()) return@setOnClickListener ToastUtils.shortShow("请输入手机号")
            if(et_password.text.toString().isNullOrBlank()) return@setOnClickListener ToastUtils.shortShow("请输入密码")

            //todo 调取接口
            mPresenter.login(User(mobile = et_phone.text.toString(),password = et_password.text.toString()))
        }

        tv_go_register.setOnClickListener {
            //todo 跳往注册页面
            startActivity(Intent(this,RegisterActivity::class.java))
        }

        tv_go_find.setOnClickListener {
            //todo 跳往找回密码页面

        }
    }

    override fun loginSuccess(){
        startActivity(Intent(this,MainActivity::class.java))
        finish()
    }


    override fun onDestroy() {
        super.onDestroy()
        mPresenter.onDestroy()
    }
}


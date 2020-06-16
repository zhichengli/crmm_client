package com.zcl.crmm_client

import android.content.Intent
import android.os.Bundle
import com.zcl.crmm_client.base.BaseActivity
import com.zcl.crmm_client.constant.SP
import com.zcl.crmm_client.login.LoginActivity

/**
 *Created by zcl
 *
 */
class SplashActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        initView()


    }

    private fun initView() {
        if(SP.token.isNullOrBlank() || SP.user==null){
            startActivity(Intent(this,LoginActivity::class.java))
            finish()
        }else{
            startActivity(Intent(this,MainActivity::class.java))
            finish()
        }
    }
}
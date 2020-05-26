package com.zcl.crmm_client

import android.content.Intent
import android.os.Bundle
import com.zcl.crmm_client.base.BaseActivity
import com.zcl.crmm_client.login.LoginActivity

/**
 *Created by zcl
 *
 */
class SplashActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        startActivity(Intent(this,LoginActivity::class.java))
        finish()
    }
}
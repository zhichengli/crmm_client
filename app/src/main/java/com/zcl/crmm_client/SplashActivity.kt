package com.zcl.crmm_client

import android.content.Intent
import android.os.Bundle
import com.zcl.crmm_client.base.BaseActivity

/**
 *Created by zcl
 *
 */
class SplashActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        startActivity(Intent(this,MainActivity::class.java))
        finish()
    }
}
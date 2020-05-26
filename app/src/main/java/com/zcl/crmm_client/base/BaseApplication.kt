package com.zcl.crmm_client.base

import android.app.Application

/**
 *Created by zcl
 *
 */
class BaseApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        instance = this
    }

    companion object{
        lateinit var instance:BaseApplication
    }
}
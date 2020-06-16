package com.zcl.crmm_client.base

import android.app.Application
import android.content.Context
import com.zcl.crmm_client.login.bean.User

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
        lateinit var user:User
        fun sharedPreference() = instance.getSharedPreferences(instance.packageName, Context.MODE_PRIVATE)
    }
}
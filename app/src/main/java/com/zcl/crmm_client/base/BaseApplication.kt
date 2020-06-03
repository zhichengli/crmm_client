package com.zcl.crmm_client.base

import android.app.Application
import android.content.Context

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
        fun sharedPreference() = instance.getSharedPreferences(instance.packageName, Context.MODE_PRIVATE)
    }
}
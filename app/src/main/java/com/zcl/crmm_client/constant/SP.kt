package com.zcl.crmm_client.constant

import com.fasterxml.jackson.databind.ObjectMapper
import com.zcl.crmm_client.base.BaseApplication
import com.zcl.crmm_client.login.bean.User

object SP {
    inline fun edit() = BaseApplication.sharedPreference().edit()!!

    var token:String
    get() = BaseApplication.sharedPreference().getString("token","").toString()
    set(value) {
        edit().putString("token",value).commit()
    }

    var user:User =  BaseApplication.sharedPreference().getString("user","").let { ObjectMapper().readValue(it,User::class.java)}
    set(value) {
        edit().putString("user",value.let { ObjectMapper().writeValueAsString(it)}).commit()}
}
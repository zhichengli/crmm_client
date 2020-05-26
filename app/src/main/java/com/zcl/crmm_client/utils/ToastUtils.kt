package com.zcl.crmm_client.utils

import android.widget.Toast
import com.zcl.crmm_client.base.BaseApplication

/**
 *Created by zcl
 *
 */
object ToastUtils {
    fun shortShow(str:String){
        Toast.makeText(BaseApplication.instance,str,Toast.LENGTH_SHORT).show()
    }
    fun longShow(str: String){
        Toast.makeText(BaseApplication.instance,str,Toast.LENGTH_LONG).show()
    }
}
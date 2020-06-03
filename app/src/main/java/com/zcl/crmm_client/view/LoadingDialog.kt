package com.zcl.crmm_client.view

import android.app.Dialog
import android.content.Context
import android.graphics.drawable.AnimationDrawable
import android.view.View
import android.widget.ImageView
import com.zcl.crmm_client.R

class LoadingDialog {
    lateinit var loadingDialog:Dialog
    lateinit var mContext:Context
    lateinit var ivLoading:ImageView
    lateinit var ad:AnimationDrawable
    constructor(context: Context){
        mContext = context
        loadingDialog = Dialog(context, R.style.FullHeightDialog)
        var view = View.inflate(context,R.layout.view_dialog,null)
        ivLoading = view.findViewById(R.id.iv_loading)
        loadingDialog.setCanceledOnTouchOutside(false)
        loadingDialog.setContentView(view)
        ad = ivLoading.drawable as AnimationDrawable
    }

    /**
     * 显示对话框
     */
    fun showDialog(){
        try {
            if(loadingDialog.isShowing){
                if(ad.isRunning) ad.stop()
                //ad.start()
                loadingDialog.dismiss()
            }else{
                loadingDialog.show()
                if(ad.isRunning) ad.stop()
                ad.start()
            }
        }catch (e:Exception){

        }
    }

    fun dismissDialog(){
        try {
            if(loadingDialog.isShowing){
                if(ad.isRunning) ad.stop()
                loadingDialog.dismiss()
            }
        }catch (e:Exception){

        }
    }
}

























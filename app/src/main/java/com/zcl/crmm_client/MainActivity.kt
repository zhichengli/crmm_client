package com.zcl.crmm_client

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import com.zcl.crmm_client.base.BaseActivity
import com.zcl.crmm_client.constant.SP
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
    }

    private fun initView() {
        var navController = Navigation.findNavController(this, R.id.vp_content)
        NavigationUI.setupWithNavController(bnv_navigation, navController)
    }


    override fun onSupportNavigateUp(): Boolean {
        return Navigation.findNavController(this, R.id.vp_content).navigateUp()
    }
}

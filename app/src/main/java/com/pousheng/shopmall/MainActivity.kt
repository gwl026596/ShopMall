package com.pousheng.shopmall

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.pousheng.baselibrary.ext.startNextActivity
import com.pousheng.usermodule.ui.RegisterActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tvGoRegister.setOnClickListener {
            val bundle=Bundle()
            bundle.putString("id","22")
            startNextActivity(bundle, RegisterActivity::class.java)
        }
    }
}
package com.pousheng.usermodule

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.pousheng.baselibrary.ext.toast
import com.pousheng.baselibrary.ui.activity.BaseMvpActivity
import com.pousheng.usermodule.presenter.RegisterPresenter
import com.pousheng.usermodule.presenter.view.RegisterView
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : BaseMvpActivity<RegisterPresenter>(),RegisterView {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        mPresenter= RegisterPresenter()
        mPresenter.mView=this
        val stringExtra = intent.extras?.getString("id")
        Log.d("好好说说",stringExtra)
        tvRegister.setOnClickListener { mPresenter.registerUser("","") }
    }

    override fun registerResult(isRegister: Boolean) {
          if (isRegister){
              toast("注册成功")
          }
    }
}

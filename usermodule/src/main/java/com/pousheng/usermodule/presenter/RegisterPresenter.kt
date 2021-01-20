package com.pousheng.usermodule.presenter

import com.pousheng.baselibrary.presenter.BasePresenter
import com.pousheng.usermodule.presenter.view.RegisterView

class RegisterPresenter : BasePresenter<RegisterView>() {

    fun  registerUser(phone:String,psw:String){
        mView.registerResult(true)
    }
}
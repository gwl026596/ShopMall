package com.pousheng.usermodule.presenter

import android.util.Log
import com.pousheng.baselibrary.data.net.CallBack
import com.pousheng.baselibrary.data.response.BaseModel
import com.pousheng.baselibrary.data.response.BaseResponse
import com.pousheng.baselibrary.presenter.BasePresenter
import com.pousheng.usermodule.data.response.ExpdetailExpModel
import com.pousheng.usermodule.presenter.view.RegisterView
import com.pousheng.usermodule.service.serviceImp.RegisterServiceImpl
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.schedulers.Schedulers


class RegisterPresenter : BasePresenter<RegisterView>() {

    /*fun  registerUser(memberId:String){
        val registerServiceImpl= RegisterServiceImpl()
        registerServiceImpl.getExpdetailExp(memberId)
            .enqueue(object : Callback<BaseResponse<BaseModel<ExpdetailExpModel>>>{
                override fun onResponse(
                    call: Call<BaseResponse<BaseModel<ExpdetailExpModel>>>,
                    response: Response<BaseResponse<BaseModel<ExpdetailExpModel>>>
                ) {
                    if (response.isSuccessful){
                        response.body()?.let {
                            mView.registerResult(it.result.result)
                        }

                    }

                }

                override fun onFailure(
                    call: Call<BaseResponse<BaseModel<ExpdetailExpModel>>>,
                    t: Throwable
                ) {

                }

            })
    }*/
    fun  registerUser(memberId:String){
        val registerServiceImpl= RegisterServiceImpl()
        registerServiceImpl.getExpdetailExp(memberId,object :CallBack<BaseResponse<BaseModel<ExpdetailExpModel>>>{
            override fun OnSuccess(data: BaseResponse<BaseModel<ExpdetailExpModel>>) {
                mView.registerResult(data.result.result)
            }

            override fun OnError(code: String, message: String) {
                Log.d("就算是",message+"=="+code)

            }

        })

    }
}





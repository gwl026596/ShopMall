package com.pousheng.usermodule.repository

import android.util.Log
import autodispose2.androidx.lifecycle.AndroidLifecycleScopeProvider
import autodispose2.autoDispose
import com.pousheng.baselibrary.data.net.BaseObserver
import com.pousheng.baselibrary.data.net.CallBack
import com.pousheng.baselibrary.data.net.RetrofitFactory
import com.pousheng.baselibrary.data.response.BaseModel
import com.pousheng.baselibrary.data.response.BaseResponse
import com.pousheng.usermodule.data.net.UserApi
import com.pousheng.usermodule.data.response.ExpdetailExpModel
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.schedulers.Schedulers
import retrofit2.Call

class RegisterRepository {

    /*fun getExpdetailExp(memberId: String?): Call<BaseResponse<BaseModel<ExpdetailExpModel>>>{
        return RetrofitFactory.instance.create(UserApi::class.java).getExpdetailExp(memberId)
    }*/
    fun getExpdetailExp(memberId: String?,callBack: CallBack<BaseResponse<BaseModel<ExpdetailExpModel>>>){
         RetrofitFactory.instance.create(UserApi::class.java).getExpdetailExp(memberId)
             .subscribeOn(Schedulers.io())
             .observeOn(AndroidSchedulers.mainThread())
             .subscribe(BaseObserver(callBack))
    }
}
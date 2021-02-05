package com.pousheng.usermodule.service

import com.pousheng.baselibrary.data.net.CallBack
import com.pousheng.baselibrary.data.response.BaseModel
import com.pousheng.baselibrary.data.response.BaseResponse
import com.pousheng.usermodule.data.response.ExpdetailExpModel
import io.reactivex.rxjava3.core.Observable
import retrofit2.Call
import retrofit2.http.Path

interface RegisterService {
    //fun getExpdetailExp(memberId: String?): Call<BaseResponse<BaseModel<ExpdetailExpModel>>>

    fun getExpdetailExp(memberId: String?,callBack: CallBack<BaseResponse<BaseModel<ExpdetailExpModel>>>)

}
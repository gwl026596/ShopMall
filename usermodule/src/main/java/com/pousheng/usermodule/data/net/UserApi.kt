package com.pousheng.usermodule.data.net

import com.pousheng.baselibrary.data.response.BaseModel
import com.pousheng.baselibrary.data.response.BaseResponse
import com.pousheng.usermodule.data.response.ExpdetailExpModel
import io.reactivex.rxjava3.core.Observable
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface UserApi {


   /* //查询会员信息以及积分兑换规则
    @GET("exp/getexpdetailExp/{memberId}")
    fun getExpdetailExp(@Path("memberId") memberId: String?): Call<BaseResponse<BaseModel<ExpdetailExpModel>>>*/
    //查询会员信息以及积分兑换规则
    @GET("exp/getexpdetailExp/{memberId}")
    fun getExpdetailExp(@Path("memberId") memberId: String?): Observable<BaseResponse<BaseModel<ExpdetailExpModel>>>


}
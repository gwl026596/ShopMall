package com.pousheng.usermodule.service.serviceImp

import com.pousheng.baselibrary.data.net.CallBack
import com.pousheng.baselibrary.data.response.BaseModel
import com.pousheng.baselibrary.data.response.BaseResponse
import com.pousheng.usermodule.data.response.ExpdetailExpModel
import com.pousheng.usermodule.repository.RegisterRepository
import com.pousheng.usermodule.service.RegisterService
import io.reactivex.rxjava3.core.Observable
import retrofit2.Call

class RegisterServiceImpl : RegisterService {
   /* override fun getExpdetailExp(memberId: String?): Call<BaseResponse<BaseModel<ExpdetailExpModel>>> {
        val registerRepository= RegisterRepository()
        return registerRepository.getExpdetailExp(memberId)
    }*/
    override fun getExpdetailExp(memberId: String?,callBack: CallBack<BaseResponse<BaseModel<ExpdetailExpModel>>>){
        val registerRepository= RegisterRepository()
         registerRepository.getExpdetailExp(memberId,callBack)
    }
}
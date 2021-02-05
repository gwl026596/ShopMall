package com.pousheng.baselibrary.data.net

import com.google.gson.JsonParseException
import com.pousheng.baselibrary.data.response.BaseResponse
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.disposables.Disposable
import org.json.JSONException
import retrofit2.HttpException
import java.net.ConnectException
import java.net.SocketTimeoutException
import java.net.UnknownHostException
import javax.net.ssl.SSLHandshakeException

open class BaseObserver<T> constructor(val callBack: CallBack<T>): Observer<T> {

    override fun onSubscribe(d: Disposable?) {

    }

    override fun onNext(t: T) {
        if (t is BaseResponse<*>){
            if (t.code=="000000"){
                callBack.OnSuccess(t)
            }else{
                callBack.OnError(t.code,t.message)
            }
        }else{
            callBack.OnSuccess(t)
        }
    }

    override fun onError(e: Throwable?) {
        if (e is ConnectException ||e is UnknownHostException){
            callBack.OnError("10001","无网络链接")
        } else if (e is SocketTimeoutException){
            callBack.OnError("10002","网络链接超时")
        }else if (e is JsonParseException || e is JSONException){
            callBack.OnError("10003","解析异常")
        }else if (e is SSLHandshakeException){
            callBack.OnError("10004","证书验证失败")
        }else if (e is HttpException){
            if (e.code()==404){
                callBack.OnError("10005","服务不存在")
            }else if (e.code()==500||e.code()==502||e.code()==503){
                callBack.OnError("10006","网络异常")
            }

        }else{
            callBack.OnError("10007","位置错误")
        }

    }

    override fun onComplete() {

    }
}
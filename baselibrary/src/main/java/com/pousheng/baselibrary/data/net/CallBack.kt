package com.pousheng.baselibrary.data.net

interface CallBack<T> {
    fun OnSuccess(data:T)
    fun OnError(code :String,message:String)
}
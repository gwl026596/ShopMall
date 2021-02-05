package com.pousheng.baselibrary.data.response

class BaseModel <T>(val error:String,val errorMessage:String,val success:Boolean,val result :T)
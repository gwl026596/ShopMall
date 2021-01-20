package com.pousheng.baselibrary.ext

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Toast

fun Activity.toast(text:String){
    Toast.makeText(this,text,Toast.LENGTH_LONG).show()
}

fun Activity.startNextActivity( cls:Class<*> ){
    val intent=Intent(this,cls)
    this.startActivity(intent)
}
fun Activity.startNextActivity(bundle:  Bundle, cls:Class<*> ){
    val intent=Intent(this,cls)
    intent.putExtras(bundle)
    this.startActivity(intent)
}
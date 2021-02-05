package com.pousheng.usermodule.ui

import android.annotation.SuppressLint
import android.content.BroadcastReceiver
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.pousheng.baselibrary.ext.toast
import com.pousheng.baselibrary.ui.activity.BaseMvpActivity
import com.pousheng.usermodule.R
import com.pousheng.usermodule.data.response.ExpdetailExpModel
import com.pousheng.usermodule.presenter.RegisterPresenter
import com.pousheng.usermodule.presenter.view.RegisterView
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : BaseMvpActivity<RegisterPresenter>(),RegisterView {

    @SuppressLint("AutoDispose")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        mPresenter= RegisterPresenter()
        mPresenter.mView=this
        val stringExtra = intent.extras?.getString("id")
        Log.d("好好说说",stringExtra.toString())
        Observable.just("1")
            .observeOn(Schedulers.io())
            .subscribeOn(AndroidSchedulers.mainThread())
            .subscribe(object :Observer<String>{
                override fun onSubscribe(d: Disposable?) {

                }

                override fun onNext(t: String) {

                }

                override fun onError(e: Throwable) {

                }

                override fun onComplete() {

                }

            })
        tvRegister.setOnClickListener { mPresenter.registerUser("20000326198") }
    }

    override fun registerResult(expModel: ExpdetailExpModel) {
        val test=MyTest()
        test.setLog()
        tvContent.text=expModel.percent
    }

    inner class  MyTest{
         fun setLog() {
             Toast.makeText(this@RegisterActivity,"测试匿名类引用外部类",Toast.LENGTH_LONG).show()
         }
     }
}

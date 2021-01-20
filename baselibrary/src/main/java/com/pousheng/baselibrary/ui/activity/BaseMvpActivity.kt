package com.pousheng.baselibrary.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.pousheng.baselibrary.R
import com.pousheng.baselibrary.presenter.BasePresenter
import com.pousheng.baselibrary.presenter.view.BaseView

open class BaseMvpActivity<T: BasePresenter<*>> : BaseActivity(),BaseView {
    lateinit var mPresenter:T
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_base_mvp)
    }

    override fun showLoading() {

    }

    override fun dismissLoading() {

    }

    override fun error() {

    }
}
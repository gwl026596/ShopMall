package com.pousheng.baselibrary.presenter

import com.pousheng.baselibrary.presenter.view.BaseView

open class BasePresenter<T:BaseView> {
    lateinit var mView :T
}
package com.pousheng.usermodule.presenter.view

import com.pousheng.baselibrary.presenter.view.BaseView
import com.pousheng.usermodule.data.response.ExpdetailExpModel

interface RegisterView :BaseView {
    fun registerResult(expModel: ExpdetailExpModel)
}
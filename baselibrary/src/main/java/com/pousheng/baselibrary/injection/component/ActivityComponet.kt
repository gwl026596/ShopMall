package com.pousheng.baselibrary.injection.component

import com.pousheng.baselibrary.injection.module.ActivityModule
import dagger.Component

@Component(modules = arrayOf(ActivityModule::class))
interface ActivityComponet {
}
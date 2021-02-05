package com.pousheng.baselibrary.injection.component

import com.pousheng.baselibrary.injection.module.ContextModule
import dagger.Component

@Component(modules = arrayOf(ContextModule::class))
interface ApplicationComponet {
}
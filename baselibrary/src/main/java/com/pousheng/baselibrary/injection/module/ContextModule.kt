package com.pousheng.baselibrary.injection.module

import android.app.Activity
import android.content.Context
import dagger.Module
import dagger.Provides

@Module
class ContextModule(private val  context: Context) {

    @Provides
    fun  providesActivity(): Context {
        return context
    }
}
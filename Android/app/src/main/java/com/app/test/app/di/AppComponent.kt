package com.app.test.app.di

import android.support.annotation.NonNull
import com.app.test.app.di.module.ContextModule
import com.app.test.app.di.module.NetworkModule
import com.app.test.app.di.module.SharedPreferenceModule
import com.app.test.ui.main.MainActivity
import com.app.test.ui.base.BaseActivity
import com.app.test.ui.base.BaseDialogFragment
import com.app.test.ui.base.BaseFragment
import com.app.test.ui.base.BasePresenter
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [NetworkModule::class, SharedPreferenceModule::class, ContextModule::class])
interface AppComponent {

    fun inject(@NonNull activity: BaseActivity)

    fun inject(@NonNull activity: MainActivity)

    fun inject(@NonNull presenter: BasePresenter)

    fun inject(@NonNull fragment: BaseDialogFragment)

    fun inject(@NonNull fragment: BaseFragment)

}
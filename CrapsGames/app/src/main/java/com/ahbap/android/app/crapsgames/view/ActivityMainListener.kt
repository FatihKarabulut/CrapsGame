package com.ahbap.android.app.crapsgames.view

import com.ahbap.android.app.crapsgames.MainActivity

import java.lang.ref.WeakReference

class ActivityMainListener(activity: MainActivity) {
    private val mWeak = WeakReference(activity)

    fun handlerRegisterClicked() = mWeak.get()!!.registerButtonClicked()
    fun handlerLoginClicked() = mWeak.get()!!.loginButtonClicked()
}
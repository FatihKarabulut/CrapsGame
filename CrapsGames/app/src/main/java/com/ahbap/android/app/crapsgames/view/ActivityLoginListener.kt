package com.ahbap.android.app.crapsgames.view

import com.ahbap.android.app.crapsgames.LoginActivity
import com.ahbap.android.app.crapsgames.Register
import java.lang.ref.WeakReference

class ActivityLoginListener(activity: LoginActivity) {
    private val mWeak = WeakReference(activity)

    fun handlerGetButtonClicked() = mWeak.get()!!.getButtonClicked()
}
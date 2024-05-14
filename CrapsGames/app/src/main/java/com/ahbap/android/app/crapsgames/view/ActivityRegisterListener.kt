package com.ahbap.android.app.crapsgames.view

import com.ahbap.android.app.crapsgames.Register
import java.lang.ref.WeakReference

class ActivityRegisterListener(activity: Register) {
    private val mWeak = WeakReference(activity)

    fun handlerGetButtonClicked() = mWeak.get()!!.registerGetButtonClicked()
    fun handlerCloseButtonClicked() = mWeak.get()!!.finish()
}
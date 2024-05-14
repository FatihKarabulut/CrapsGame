package com.ahbap.android.app.dataservicelib

import java.io.Serializable
import java.time.LocalDateTime

data class Entity(var id: Int = 0,
                  var name: String = "",
                  var nickName: String = "",
                  var password: String = "",
                  var confirmedPassword: String = "",
                  var registerDate: LocalDateTime = LocalDateTime.now()
) : Serializable
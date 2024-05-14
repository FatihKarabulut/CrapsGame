package com.ahbap.android.app.crapsrepository.databases.converter

import androidx.room.TypeConverter
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class RegisterDateConverter {
    @TypeConverter
    fun toDate(str : String) : LocalDateTime  = LocalDateTime.parse(str, DateTimeFormatter.ISO_DATE_TIME)

    @TypeConverter
    fun toStr(str : LocalDateTime) : String = DateTimeFormatter.ISO_DATE_TIME.format(str)
}
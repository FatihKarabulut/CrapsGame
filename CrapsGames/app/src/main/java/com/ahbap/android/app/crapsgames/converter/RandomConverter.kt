package com.ahbap.android.app.crapsgames.converter

import androidx.databinding.InverseMethod

object RandomConverter
{
    @InverseMethod("toStr")
    fun toInt(str : String) : Int
    {
        return  try {
            str.toInt()
        }
        catch (_:NumberFormatException)
        {
            0
        }
    }
    fun toStr(str : Int) : String =  str.toString()


}
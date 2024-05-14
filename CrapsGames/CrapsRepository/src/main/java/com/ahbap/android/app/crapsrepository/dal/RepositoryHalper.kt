package com.ahbap.android.app.crapsrepository.dal

import com.ahbap.android.app.crapsrepository.User
import com.ahbap.android.app.crapsrepository.dao.IUserDao
import javax.inject.Inject

class RepositoryHalper @Inject constructor() {
    @Inject
    lateinit var data : IUserDao

    fun insert(user : User) : Boolean
    {
        var result = false
        try {
            data.insert(user)
            result = true
        }
        catch (_:Throwable)
        {
            result = false
        }
        return  result
    }

    fun ExistsByNickNameAndPassword(nickName : String, password : String) : Boolean
    {
        try {
            return data.exitsByUsername(nickName,password)
        }
        catch (_:Throwable)
        {
            throw IllegalArgumentException("Repo Error")
        }

    }
    fun userGet(nickName : String) : User?
    {
        try {
            return data.getUser(nickName)
        }
        catch (_:Throwable)
        {
            throw IllegalArgumentException("Repo Error")
        }

    }
}
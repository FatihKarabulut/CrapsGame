package com.ahbap.android.app.crapsrepository.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.ahbap.android.app.crapsrepository.User

@Dao
interface IUserDao
{
    @Insert
    fun insert(user: User)

    @Query("SELECT EXISTS(SELECT * FROM users u WHERE u.nick_name = :username AND u.password = :password)")
    fun exitsByUsername(username: String, password : String): Boolean

    @Query("SELECT * FROM users u WHERE u.nick_name = :nickname")
    fun getUser(nickname: String) : User?

}
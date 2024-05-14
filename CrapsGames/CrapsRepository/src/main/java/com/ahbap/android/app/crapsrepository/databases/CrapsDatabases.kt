package com.ahbap.android.app.crapsrepository.databases

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.ahbap.android.app.crapsrepository.User
import com.ahbap.android.app.crapsrepository.dao.IUserDao
import com.ahbap.android.app.crapsrepository.databases.converter.RegisterDateConverter

@Database(entities = [User::class], version = 1, exportSchema = true )
@TypeConverters(RegisterDateConverter::class)
abstract class CrapsDatabases : RoomDatabase() {

    abstract fun createUserDao() : IUserDao
}
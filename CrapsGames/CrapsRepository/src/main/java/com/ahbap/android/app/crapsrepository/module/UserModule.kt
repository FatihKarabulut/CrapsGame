package com.ahbap.android.app.crapsrepository.module

import com.ahbap.android.app.crapsrepository.dao.IUserDao
import com.ahbap.android.app.crapsrepository.databases.CrapsDatabases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UserModule {
    @Provides
    @Singleton
    fun createUser(databases: CrapsDatabases) : IUserDao
    {
        return databases.createUserDao()
    }
}
package com.ahbap.android.app.crapsrepository.module

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.ahbap.android.app.crapsrepository.databases.CrapsDatabases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.internal.Contexts
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RomModule {
    @Provides
    @Singleton
    fun createRom(@ApplicationContext context : Context) : CrapsDatabases {
        return Room.databaseBuilder(context, CrapsDatabases::class.java, "craps.db").build()
    }
}
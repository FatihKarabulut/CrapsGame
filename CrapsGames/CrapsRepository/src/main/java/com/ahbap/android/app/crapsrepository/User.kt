package com.ahbap.android.app.crapsrepository

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable
import java.time.LocalDateTime

@Entity(tableName = "users")
data class User ( @PrimaryKey(autoGenerate = true) var id : Int = 0,
            var name : String = "",
           @ColumnInfo(name = "nick_name") var nickName : String = "",
            var password : String = "",
            @ColumnInfo(name = "register_date")var registerDate : LocalDateTime = LocalDateTime.now()) : Serializable


package com.ahbap.android.app.dataservicelib.mapper

import com.ahbap.android.app.crapsrepository.User
import com.ahbap.android.app.dataservicelib.Entity
import org.mapstruct.Mapper
import org.mapstruct.control.MappingControl.Use

@Mapper(implementationName = "EntityImpl")
interface IMapper
{
    fun toUser(entity: Entity) : User

    fun toEntity(user: User) : Entity
}
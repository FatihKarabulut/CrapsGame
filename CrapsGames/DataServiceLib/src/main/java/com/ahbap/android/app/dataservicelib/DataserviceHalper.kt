package com.ahbap.android.app.dataservicelib

import com.ahbap.android.app.crapsrepository.User
import com.ahbap.android.app.crapsrepository.dal.RepositoryHalper
import com.ahbap.android.app.dataservicelib.mapper.IMapper
import javax.inject.Inject

class DataserviceHalper @Inject constructor( repo : RepositoryHalper,  mapper : IMapper) {
    private val mappers = mapper
    private val repositoryHalper = repo

    fun insert(user : Entity) : Boolean
    {

        try {
           return repositoryHalper.insert(mappers.toUser(user))

        }

        catch (_:Throwable)
        {
            throw Throwable("DataService Throwable Exception")
        }

    }

    fun ExistsByNickNameAndPassword(nickName : String, password : String) : Boolean
    {
        try {
            return repositoryHalper.ExistsByNickNameAndPassword(nickName,password)
        }
        catch (ex:IllegalArgumentException)
        {
            throw IllegalArgumentException(ex.message)
        }
        catch (_:Throwable)
        {
            throw Throwable("DataService Throwable Exception")
        }

    }
    fun userGet(nickName : String) : Entity?
    {
        try {
            return repositoryHalper.userGet(nickName)?.let { mappers.toEntity(it) }
        }
        catch (_:Throwable)
        {
            throw IllegalArgumentException("Repo Error")
        }

    }
}
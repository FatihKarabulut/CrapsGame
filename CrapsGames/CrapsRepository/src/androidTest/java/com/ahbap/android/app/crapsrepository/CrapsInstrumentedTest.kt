package com.ahbap.android.app.crapsrepository

import androidx.room.Room
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.ahbap.android.app.crapsrepository.dao.IUserDao
import com.ahbap.android.app.crapsrepository.databases.CrapsDatabases

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import org.junit.Before
import java.io.File
import java.time.LocalDateTime

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class CrapsInstrumentedTest {
    companion object{
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext

    }
    private var database : CrapsDatabases? = null
    private lateinit var IUser : IUserDao
    private fun init()
    {


    }
    private fun ExistsDatabase()
    {


        val file = File(appContext.filesDir, "craps1.dbs").listFiles()

        if (file != null)
            for (i in file)
                i.delete()
    }
    @Before
    fun setUp()
    {
        ExistsDatabase()
        database = Room.databaseBuilder(appContext,CrapsDatabases::class.java,"craps1.dbs").build()
        IUser = database!!.createUserDao()
        val user = User(0,"ilyas","ilyas@gmail.com","123456",LocalDateTime.now())
        IUser.insert(user)

    }

    @Test
    fun NicknameAndPassword()
    {

        val bool = IUser.exitsByUsername("ilyas@gmail.com","123456")
        assertTrue(bool)

    }
    @Test
    fun UserTest()
    {
        assertNotNull(IUser.getUser("ilyas@gmail.com"))
    }
}
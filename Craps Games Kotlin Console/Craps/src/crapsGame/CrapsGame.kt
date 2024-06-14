package crapsGame

import console.Console.readInt
import kotlin.random.Random

object CrapsGame{
    private var m_User : Int = 0
    private var m_Bot : Int = 0
    private var m_User_Bound = 0
    private var Bound = true

    fun run()
    {
        while (true)
        {
            if (m_Bot == 3)
            {
                botMsg()
                m_Bot = 0
                m_User = 0
                m_User_Bound = 0
                Bound = true
                return
            }
            else if (m_User == 3)
            {
                userMsg()
                botMsg()
                m_Bot = 0
                m_User = 0
                m_User_Bound = 0
                Bound = true
                return
            }
            val n = readInt("\nbaşlamak için 1'i tuşlayınız")
            if (n != 1)
                erorMsg()
            else
                starter()

        }
    }
    private fun starter()
    {
        if (Bound)
            craps()
        else
            crapsBoundTrue()
    }
    private fun randomNumber() : Int
    {
        var a = 5
        try {
            while (a-- > 0)
            {
                val random = Random.nextInt(1,10)
                print("\r (  $random  )  ")
                    Thread.sleep(500)
            }

        }
        catch (ex: InterruptedException)
        {
            println(ex)
        }
        catch (ex: Throwable)
        {
            println(ex)
        }

        val n = Random.nextInt(1,10)
        print("\r (  $n  )  \n")
        println("\r çıkan Sayı $n")
        return n
    }
    private fun craps()
    {

        var n = randomNumber()

        if (n == 7 || n == 11)
        {
            ++m_User
            println("User 1 arttı \n User $m_User --- $m_Bot Bot")
            Bound = true
        }
         if (n == 2 || n == 3 || n == 12)
        {
            ++m_Bot
            println("Bot 1 arttı \n User $m_User --- $m_Bot Bot")
            Bound = true
        }


            m_User_Bound = n
            Bound = false


    }
    private fun crapsBoundTrue()
    {

            println("çıkartmanız gereken sayı $m_User_Bound")
           val n = randomNumber()
            if (n == m_User_Bound)
            {

                ++m_User
                m_User_Bound = 0
                Bound = true
                println("User 1 arttı \n User $m_User --- $m_Bot Bot")
                return
            }
            else if (n == 2 || n == 3 || n == 12)
            {

                ++m_Bot
                m_User_Bound = 0
                Bound = true
                println("Bot 1 arttı \n User $m_User --- $m_Bot Bot")
                return
            }
    }
    private fun botMsg()
    {
        println("malesef kaybettiniz")
    }
    private fun userMsg()
    {
        println("tebrikler siz kazandınız")
    }

    private fun erorMsg()
    {
        println("hatalı sayı girdiniz tekrar giriniz")
    }

}
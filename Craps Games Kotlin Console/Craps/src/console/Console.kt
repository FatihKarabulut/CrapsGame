package console

object Console {
    fun readInt(msg : String = "", err:String = "Eror") : Int
    {
        while (true) {
            try {
                println(msg)
               return readln().toInt()
            }
            catch (ex: NumberFormatException) {
                println(err)
            }
        }
    }
}
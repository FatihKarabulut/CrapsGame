package console;

import java.util.Scanner;

public class Console {

    public static int readInt(String msg, String err)
    {
        var kb = new Scanner(System.in);
        while (true)
        {
            try {
                System.out.println(msg);
                return Integer.parseInt(kb.nextLine());
            }
            catch (NumberFormatException ex)
            {
                System.out.println(err);
            }


        }

    }
    public static int readInt(String msg)
    {
        return readInt(msg,"");
    }
    public static int readInt()
    {
        return  readInt("");
    }
}

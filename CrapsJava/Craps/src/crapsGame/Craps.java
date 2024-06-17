package crapsGame;

import java.util.Random;

import static console.Console.*;

public class Craps{
    private int mBotScore = 0;
    private int mUserScore = 0;
    private int m_User_Bound  = 0;
    private boolean mFlag = false;
    private final Random random = new Random();

    public void run()
    {
        while (true)
        {
            if (mUserScore == 3)
            {
                userMsg();
                return;
            }
            else if (mBotScore == 3)
            {
                botMsg();
                return;
            }

            var n = readInt("Başlamak için 1'i tuşlayınız");
            if (n == 1)
                starter();
            else
                erorMsg();

        }
    }
    private void starter()
    {
        if (mFlag)
            crapsFlagTrue();

        else
            crapsFlagFalse();
    }
    private int randomNumber()
    {
        var a = 5;

        while (a-- > 0)
        {
            try {
                System.out.printf("\r (%d) ",random.nextInt(1,12));

                Thread.sleep(500L);
            }
            catch (InterruptedException ex)
            {
                System.out.println(ex.getMessage());
            }

        }
        var n = random.nextInt(1,9);
        System.out.printf("\r (%d) %n",n);
        System.out.printf("çıkan sayı %d%n",n);
        return n;
    }
    private void crapsFlagFalse()
    {
        var n = randomNumber();
        if (n == 7 || n == 11)
        {
            ++mUserScore;
            System.out.printf("user bir arttı User %d -- %d Bot%n",mUserScore,mBotScore);
        }
        else if (n == 2 || n == 3 || n == 12)
        {
            ++mBotScore;
            System.out.printf("bot bir arttı User %d -- %d Bot%n",mUserScore,mBotScore);
        }
        else
        {
            System.out.println("çıkartmanız gereken sayı " + n);
            m_User_Bound = n;
            mFlag = true;

        }


    }
    private void crapsFlagTrue()
    {

        var n = randomNumber();

        if (n == m_User_Bound)
        {
            ++mUserScore;
            mFlag = false;
            m_User_Bound = 0;
            System.out.printf("user bir arttı User %d -- %d Bot%n",mUserScore,mBotScore);
        }
        else if (n == 2 || n == 3 || n == 12)
        {
            ++mBotScore;
            mFlag = false;
            m_User_Bound = 0;
            System.out.printf("bot bir arttı User %d -- %d Bot%n",mUserScore,mBotScore);
        }
    }
    private void botMsg()
    {
        System.out.println("**********************************");
        System.out.println("malesef kaybettiniz");
        System.out.println("**********************************");
    }
    private void userMsg()
    {
        System.out.println("**********************************");
        System.out.println("tebrikler siz kazandınız");
        System.out.println("**********************************");
    }
    private void erorMsg()
    {
        System.out.println("hatalı tuşlama yaptınız");
    }

}
package helper;

import soldiers.*;

import java.util.Random;

public class Selective {


    /**
     *It determines the action the soldier must take,
     *  which varies according to the rank of the soldier.
     * @param sold soldier who must take action
     * @return 1) move  2) Fire 3) keep position -1) Error
     */
    public  static int actionDeterminerForSoldiers(Soldier sold)
    {
        Random random = new Random();
        if(sold.getClass().getSimpleName().equals("Er"))
        {
          int opt  = random.nextInt() % 101; // options [0 - 100]

            if(opt >=0 && opt < 30) // fire %30
            {
                return 1;
            }
            else  if( opt >=30 && opt < 70) // move %40
            {
                return  2;
            }
            else {// keep position %30
                return 3;
            }
        }
        else if(sold.getClass().getSimpleName().equals("Tegmen"))
        {
            int opt  = random.nextInt() % 101; // options [0 - 100]

            if(opt >=0 && opt < 45) // fire %45
            {
                return 1;
            }
            else  if( opt >=45 && opt < 75) // move %30
            {
                return  2;
            }
            else {// keep position %25
                return 3;
            }
        }
       else if(sold.getClass().getSimpleName().equals("Yuzbasi"))
        {
            int opt  = random.nextInt() % 101; // options [0 - 100]

            if(opt >=0 && opt < 40) // fire %40
            {
                return 1;
            }
            else  if( opt >=40 && opt < 65) // move %25
            {
                return  2;
            }
            else {// keep position %35
                return 3;
            }
        }
        else{
            return  -1;
        }
    }



}

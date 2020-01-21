package soldiers;

import helper.IDefine;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Er extends Soldier implements IDefine {


    public Er(int x, int y, String team,String name) {
        super(x, y, team, "level 1",name);
        defineAvailableDamage();
    }

    /**
     * I added the damage the soldier can do
     */
    @Override
    public void defineAvailableDamage()
    {
        super.setDamages(new ArrayList<>(Arrays.asList(5,10,15)));

    }

    /**
     * Possibility of maintaining position %30
     */
    @Override
    public void keepPosition() {
        super.keepPosition();
    }

    /**
     * soldier only moves up or down except in exceptional cases
     * possibility of movement %40
     */
    @Override
    public void move() {


        Random random = new Random();
        int decision = random.nextInt() % 40; // normalization

        if(decision >= 0 && decision <=24 )// up %25
        {

            if(getCoord().getY() != 15)
               getCoord().setY(getCoord().getY() + 1);
            else{ //corner cases
                if(getCoord().getX() != 15) //right
                    getCoord().setX(getCoord().getX() +1);
            }
        }
        else{ //down % 15
            if(getCoord().getY() != 0)
                getCoord().setY(getCoord().getY() - 1);
            else { // corner cases
                if(getCoord().getX() != 0) // left
                    getCoord().setX(getCoord().getX() - 1);

            }
        }
    }

    /**
     * possibility of shooting % 30
     * @return damage amount
     */
    @Override
    public int fire() {
        Random random = new Random();
        int decision = random.nextInt() % 30; //normalization
        if(decision >= 0 && decision<=14)
            return super.getDamages().get(0);
        else if(decision >=15 && decision<= 24)
            return super.getDamages().get(1);
        else  return  super.getDamages().get(2);
    }
}

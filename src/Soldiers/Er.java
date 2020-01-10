package Soldiers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Er extends Soldier {


    public Er(int x, int y, String team) {
        super(x, y, team, "level 1");
        defineAvailableDamage();
    }

    /**
     * I added the damage the soldier can do
     */
    private void defineAvailableDamage()
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

            if(super.getY() != 15)
               super.setY(super.getY() + 1);
            else{ //corner cases
                if(super.getX() != 15) //right
                    super.setX(super.getX() +1);
            }
        }
        else{ //down % 15
            if(super.getY() != 0)
                super.setY(super.getY() - 1);
            else { // corner cases
                if(super.getX() != 0) // left
                    super.setX(super.getX() - 1);

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

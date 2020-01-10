package Soldiers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Er extends Soldier {


    public Er(int x, int y, String team) {
        super(x, y, team, "level 1");
        defineAvailableDamage();
    }

    private void defineAvailableDamage()
    {
        super.setDamages(new ArrayList<>(Arrays.asList(5,10,15)));

    }



    @Override
    public void keepPosition() {
        super.keepPosition();
    }

    /**
     * soldier only moves up or down except in exceptional cases
     */
    @Override
    public void move() {

        Random random = new Random();
        int decision = random.nextInt() % 2;

        if(decision == 0)// up
        {

            if(super.getY() != 15)
               super.setY(super.getY() + 1);
            else{ //corner cases
                if(super.getX() != 15) //right
                    super.setX(super.getX() +1);
            }
        }
        else{ //down
            if(super.getY() != 0)
                super.setY(super.getY() - 1);
            else { // corner cases
                if(super.getX() != 0) // left
                {
                    super.setX(super.getX() - 1);
                }
            }

        }
    }

    @Override
    public int fire() {
        return super.fire();
    }
}

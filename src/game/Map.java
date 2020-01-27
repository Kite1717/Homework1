package game;


import helper.Coordinate;
import helper.Logger;
import soldiers.Soldier;

import java.util.Random;

public class Map {

    private  Team t1 , t2;
    private  int maxMapRow , maxMapColumn;

    public Map(Team t1 , Team t2 , int maxMapRow,int maxMapColumn)
    {
        this.t1 = t1;
        this.t2 = t2;
        this.maxMapRow = maxMapRow;
        this.maxMapColumn = maxMapColumn;
        placeTeamsOnMap();

    }


    /**
     * places teams in the diagonal corners of the map
     */
    private  void  placeTeamsOnMap()
    {


        
    }
    /**
     * Checks the coordinate suitability and checks if the soldier can perform the movement.
     * @param coord new coordinate of soldier
     * @return coordinate suitability
     */
    public boolean availablePosition(Coordinate coord)
    {

        //corner cases
        if( !(coord.getX() >= 0 && coord.getX() <= maxMapRow &&
            coord.getY() >= 0 && coord.getY() <= maxMapColumn))
            return  false;

        for(Soldier s : t1.getSoldiers())
            if(s.getCoord().equals(coord))
                return  false;

        for(Soldier s : t2.getSoldiers())
            if(s.getCoord().equals(coord))
                return  false;
            return true;
    }

    /**
     * Takes a soldier to shoot and lets him shoot at the enemy soldier on the map.
     * @param sold soldier who will shoot
     * @return success of firing action
     */
    public  boolean applySoldierAttack(Soldier sold)
    {

        //soldier damage and fire range
          int damage = sold.fire() , fireRange;


          //switch fire range
        switch (sold.getClass().getSimpleName()) {
            case "Er":
                fireRange = 1;
                break;
            case "Tegmen":
                fireRange = 2;
                break;
            case "Yuzbasi":
                fireRange = 3;
                break;
            default:
                Logger.addLog("Asker olusturulamama hatasi");
                return false;
        }


        boolean successfulShot = false;
        //fire process
        if(sold.getTeam().equals(t1.getName()))
        {

            for(Soldier s : t2.getSoldiers())
            {
                //successfully attack
                if(Math.abs(s.getCoord().getX() - sold.getCoord().getX()) == fireRange  ||
                        Math.abs(s.getCoord().getY() - sold.getCoord().getY()) == fireRange)
                {
                    StringBuilder sb = new StringBuilder(); //report
                    sb.append(sold.toString()).append(" Ates etti  ->>  ").append("  Hedef asker :  ").append(s.toString()).append("  Verdigi hasar  : ").append(damage);

                    s.setHeal((s.getHeal() - damage) < 0 ?  0  : s.getHeal() - damage );

                    if(s.getHeal() == 0) //is dead control
                    {
                        sb.append("   Kalan can : ").append(s.getHeal()).append(" --- DEAD --- ");

                        //the dead soldier comes out
                        t2.getSoldiers().remove(s);

                    }
                    else{
                        sb.append("   Kalan can : ").append(s.getHeal());
                    }
                    Logger.addLog(sb.toString());

                    successfulShot = true;
                    break;
                }


            }
        }
        else {

            for(Soldier s : t1.getSoldiers())
            {
                //successfully attack
                if(Math.abs(s.getCoord().getX() - sold.getCoord().getX()) ==  fireRange ||
                        Math.abs(s.getCoord().getY() - sold.getCoord().getY()) == fireRange)
                {
                    StringBuilder sb = new StringBuilder(); //report
                    sb.append(sold.toString()).append(" Ates etti  ->>  ").append("  Hedef asker :  ").append(s.toString()).append("  Verdigi hasar  : ").append(damage);

                    s.setHeal((s.getHeal() - damage) < 0 ?  0  : s.getHeal() - damage );

                    if(s.getHeal() == 0) //is dead control
                    {
                        sb.append("   Kalan can : ").append(s.getHeal()).append(" --- DEAD --- ");

                        //the dead soldier comes out
                        t1.getSoldiers().remove(s);

                    }
                    else{
                        sb.append("   Kalan can : ").append(s.getHeal());
                    }
                    Logger.addLog(sb.toString());

                    successfulShot = true;
                    break;

                }


            }

        }

        //miss process
        if(!successfulShot)
        {
            Logger.addLog(sold.toString() +"  Ates etti ->> Hedef yoktu iskaladi");
        }

        return successfulShot;
    }

}

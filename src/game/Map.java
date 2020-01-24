package game;


import helper.Coordinate;
import soldiers.Soldier;

public class Map {

    private  Team t1 , t2;
    private  int maxMapRow , maxMapColumn;

    public Map(Team t1 , Team t2 , int maxMapRow,int maxMapColumn)
    {
        this.t1 = t1;
        this.t2 = t2;
        this.maxMapRow = maxMapRow;
        this.maxMapColumn = maxMapColumn;

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
















}

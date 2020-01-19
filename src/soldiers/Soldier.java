package soldiers;

import  helper.Coordinate;

import java.util.ArrayList;

public class Soldier  extends  Coordinate{

    private int heal;
    private boolean isAlive;
    private String team;
    private String rank;
    private ArrayList<Integer> damages;



//region constructor
    /**
     *
     * @param x vertex coordinate of soldier
     * @param y horizontal coordinate of soldier
     * @param team selected team
     * @param rank level info
     */
    public Soldier(int x, int y , String team, String rank) {
        super(x, y);
        this.heal = 100;
        this.isAlive = true;
        this.team = team;
        this.rank = rank;
        damages = new ArrayList<>();
    }
    //endregion

    //region gettersAndSetters

    public int getHeal() {
        return heal;
    }

    public void setHeal(int heal) {
        this.heal = heal;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }


    public ArrayList<Integer> getDamages() {
        return damages;
    }

    public void setDamages(ArrayList<Integer> damages) {
        this.damages = damages;
    }
    //endregion



    //region standardMethods
    public void keepPosition()
    {

    }

    public void  move()
    {
        throw  new UnsupportedOperationException();
    }
    public int fire()
    {
        throw  new UnsupportedOperationException();
    }
   //endregion
}

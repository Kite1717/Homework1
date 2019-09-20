

public class Soldier  extends Coordinate{

    private int heal;
    private boolean isAlive;
    private String team;
    private String rank;

    public Soldier(int x, int y , String team, String rank) {
        super(x, y);
        this.heal = 100;
        this.isAlive = true;
        this.team = team;
        this.rank = rank;
    }

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

    public void keepPosition()
    {
     throw  new UnsupportedOperationException();
    }

    public void  move()
    {
        throw  new UnsupportedOperationException();
    }
    public int fire()
    {
        throw  new UnsupportedOperationException();
    }

}

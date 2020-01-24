package game;

import soldiers.Er;
import soldiers.Soldier;
import soldiers.Tegmen;
import soldiers.Yuzbasi;

import java.util.ArrayList;
import java.util.Random;

public class Team {

    private  String name;
    private ArrayList<Soldier> soldiers;
    private int soldierLimit = 1;


    public Team(String name,int soldierLimit) {
        this.name = name;
        if(soldierLimit > 1)
        this.soldierLimit = soldierLimit;
        createTeam();
    }

    /**
     * Soldiers are created up to the military limit
     */
    private void createTeam()
    {
        Random random = new Random();
        int decision;
        //max one Yuzbasi
        int limitOfYuzbasi = 1;

        //min 1 max 2 Tegmen
        int limitOfTegmen = 1;

        //default add one tegmen
        soldiers.add(new Tegmen(0,0,name,"Tegmen 1"));

        for (int i = 1 , countOfEr = 1; i <= soldierLimit-1 ; i++)
        {
            decision = random.nextInt() % 3;
            if(decision ==0){ // er

                soldiers.add(new Er(0,0,name,"Er " + countOfEr));
                countOfEr++;
            }
            else  if( decision == 1 && limitOfTegmen  > 0){ // tegmen

                soldiers.add(new Tegmen(0,0,name,"Tegmen " + limitOfTegmen +1));
                limitOfTegmen--;
            }
            else  if(decision == 2 && limitOfYuzbasi > 0){ // yuzbasi

                soldiers.add(new Yuzbasi(0,0,name  , "Yuzbasi 1"));
                limitOfYuzbasi--;
            }
        }

    }

    //region getters
    public String getName() {
        return name;
    }

    public ArrayList<Soldier> getSoldiers() {
        return soldiers;
    }
    //endregion
}

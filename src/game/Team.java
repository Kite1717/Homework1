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

    private void createTeam()
    {
        Random random = new Random();
        int decision;
        int limitOfYuzbasi = 1;
        int limitOfTegmen = 1;

        //default add one tegmen
        soldiers.add(new Tegmen(0,0,name));

        for (int i = 1; i <= soldierLimit-1 ; i++)
        {
            decision = random.nextInt() % 3;
            if(decision ==0){ // er

                soldiers.add(new Er(0,0,name));
            }
            else  if( decision == 1 && limitOfTegmen  > 0){ // tegmen

                soldiers.add(new Tegmen(0,0,name));
                limitOfTegmen--;
            }
            else  if(decision == 2 && limitOfYuzbasi > 0){ // yuzbasi

                soldiers.add(new Yuzbasi(0,0,name));
                limitOfYuzbasi--;
            }
        }

    }

}

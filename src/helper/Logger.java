package helper;

import java.util.ArrayList;

public class Logger {


    private  static ArrayList<String> logs = new ArrayList<>();


    public  static void  addLog(String log)
    {
        logs.add(log);
    }



}

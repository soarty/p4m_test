package p4m.loader.Timer;

import java.util.Date;

/**
 * Created by soart on 05.05.2015.
 */
public class EventTimer extends Thread{
    int repeatTime = 1000;
    @Override
    public void run() {}

    public void setRepeatTime(int RepeatTime){
        this.repeatTime = RepeatTime;
    }

    public int getRepeatTime(){
        return this.repeatTime;
    }

    public void printDate(String text) {
        System.out.println(text);
        Date dateStart = new Date();
        System.out.println(dateStart.toString());
    }
}

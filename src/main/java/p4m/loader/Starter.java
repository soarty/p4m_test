/**
 * Created by soart on 28.03.2015.
 */
package p4m.loader;

import p4m.loader.Timer.EventLoadHero;
import p4m.loader.Timer.EventLoadMatch;
import p4m.loader.Timer.EventLoadStatsDaily;
import java.util.Date;

public class Starter {
    public static void main(String[] args) throws Exception {
        EventLoadHero heroLoader = new EventLoadHero();
        heroLoader.setRepeatTime(3600000);
        heroLoader.start();

        EventLoadMatch matchLoader = new EventLoadMatch();
        matchLoader.setRepeatTime(60000);
        matchLoader.start();

        EventLoadStatsDaily dailyStatsLoader = new EventLoadStatsDaily();
        dailyStatsLoader.setRepeatTime(60000);
        dailyStatsLoader.start();

        /*if(!heroLoader.isAlive() && !matchLoader.isAlive() && !dailyStatsLoader.isAlive())
            System.exit(0);*/
    }
}

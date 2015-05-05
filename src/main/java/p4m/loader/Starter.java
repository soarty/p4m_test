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
        Date dateStart = new Date();
        System.out.println(dateStart.toString());

        EventLoadHero heroLoader = new EventLoadHero();
        heroLoader.setRepeatTime(3600000);
        heroLoader.start();

        EventLoadMatch matchLoader = new EventLoadMatch();
        matchLoader.setRepeatTime(60000);
        matchLoader.start();

        EventLoadStatsDaily dailyStatsLoader = new EventLoadStatsDaily();
        dailyStatsLoader.setRepeatTime(60000);
        dailyStatsLoader.start();
        /*ManagerHeroDAO heroManger = new ManagerHeroDAO();
        heroManger.saveOrUpdateArray();
        System.out.println("p4m.hero loaded");*/

        /*ManagerUserDAO userManager = new ManagerUserDAO();
        List<Object> userList = userManager.getQueryList();

        D2User d2u;
        ManagerMatchDAO matchManager = new ManagerMatchDAO();
        for (Object du:userList)
        {
            d2u = (D2User)du;
            matchManager.saveOrUpdateArray(d2u.GetSteamId());
        }
        System.out.println("p4m.match loaded");
        D2Match d2m;
        ManagerStatsDailyDAO dailyDAO = new ManagerStatsDailyDAO();
        List<Object> matchList = matchManager.getQueryList();
        for (Object match:matchList) {
            d2m = (D2Match) match;
            dailyDAO.saveOrUpdateArray(d2m.GetMatchId());
            d2m.SetLoaded("Y");
            matchManager.saveOrUpdate(d2m);
        }
        //heroManger.closeFactory();

        Date dateEnd = new Date();
        System.out.println(dateEnd.toString());
        System.out.println("p4m.stats daily loaded");*/

        if(!heroLoader.isAlive() && !matchLoader.isAlive() && !dailyStatsLoader.isAlive())
            System.exit(0);
    }
}

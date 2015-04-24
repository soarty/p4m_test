/**
 * Created by soart on 28.03.2015.
 */
package p4m.loader;

import p4m.loader.D2Tables.D2Match;
import p4m.loader.D2Tables.D2User;
import p4m.loader.D2Tables.D2UserDaily;
import p4m.loader.ManagerDAO.*;

import java.util.Date;
import java.util.List;
import java.util.Map;

public class Starter {
    public static void main(String[] args) throws Exception {
        Date dateStart = new Date();
        System.out.println(dateStart.toString());

        ManagerHeroDAO heroManger = new ManagerHeroDAO();
        heroManger.saveOrUpdateArray();
        System.out.println("p4m.hero loaded");

        ManagerUserDAO userManager = new ManagerUserDAO();
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
        for (Object match:matchList)
        {
            d2m = (D2Match)match;
            dailyDAO.saveOrUpdateArray(d2m.GetMatchId());
            d2m.SetLoaded('Y');
            matchManager.saveOrUpdate(d2m);
        }

        Date dateEnd = new Date();
        System.out.println(dateEnd.toString());
        System.out.println("p4m.stats daily loaded");
    }
}

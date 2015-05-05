package p4m.loader.Timer;

import p4m.loader.D2Tables.D2Match;
import p4m.loader.ManagerDAO.ManagerMatchDAO;
import p4m.loader.ManagerDAO.ManagerStatsDailyDAO;

import java.util.List;

/**
 * Created by soart on 05.05.2015.
 */
public class EventLoadStatsDaily extends EventTimer{
    @Override
    public void run(){
        {
            for (;;) {
                printDate("Начало загрузки результатов матчей");
                ManagerMatchDAO matchManager = new ManagerMatchDAO();
                D2Match d2m;
                ManagerStatsDailyDAO dailyDAO = new ManagerStatsDailyDAO();
                List<Object> matchList = matchManager.getQueryList();
                for (Object match:matchList) {
                    d2m = (D2Match) match;
                    try {
                        dailyDAO.saveOrUpdateArray(d2m.GetMatchId());
                    }
                    catch (Exception ex)
                    {
                        System.err.println("Ошибка загрузки результатов матчей");
                        ex.printStackTrace();
                    }
                    d2m.SetLoaded("Y");
                    matchManager.saveOrUpdate(d2m);
                }
                printDate("Окончание загрузки результатов матчей");
                matchManager = null;
                dailyDAO = null;
                System.gc();
                try {
                    this.sleep(super.repeatTime);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

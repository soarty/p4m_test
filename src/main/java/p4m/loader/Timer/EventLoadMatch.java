package p4m.loader.Timer;

import p4m.loader.D2Tables.D2User;
import p4m.loader.ManagerDAO.ManagerHeroDAO;
import p4m.loader.ManagerDAO.ManagerMatchDAO;
import p4m.loader.ManagerDAO.ManagerUserDAO;

import java.util.List;

/**
 * Created by soart on 05.05.2015.
 */
public class EventLoadMatch extends EventTimer{
    @Override
    public void run()
    {
        for (;;) {
            printDate("Начало загрузки матчей");
            ManagerUserDAO userDAO = new ManagerUserDAO();
            List<Object> userList = userDAO.getQueryList();
            D2User d2u;
            ManagerMatchDAO matchManager = new ManagerMatchDAO();
            for (Object du:userList)
            {
                d2u = (D2User)du;
                try {
                    matchManager.saveOrUpdateArray(d2u.GetSteamId());
                }
                catch (Exception ex)
                {
                    System.err.println("Ошибка загрузки матча для пользователя "+d2u.GetSteamId());
                    ex.printStackTrace();
                }
            }
            matchManager = null;
            System.gc();
            printDate("Окончание загрузки матчей");
            try {
                this.sleep(super.repeatTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}


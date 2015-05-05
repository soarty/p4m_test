package p4m.loader.Timer;

import p4m.loader.ManagerDAO.ManagerHeroDAO;

/**
 * Created by soart on 05.05.2015.
 */
public class EventLoadHero extends EventTimer {
    @Override
    public void run(){
        {
            for (;;) {
                printDate("Начало загрузки героев");
                ManagerHeroDAO heroManger = new ManagerHeroDAO();
                try {
                    heroManger.saveOrUpdateArray();
                } catch (Exception ex) {
                    System.err.println("Ошибка загрузки героев");
                    ex.printStackTrace();
                }
                heroManger = null;
                System.gc();
                printDate("Окончание загрузки героев");
                try {
                    this.sleep(super.repeatTime);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

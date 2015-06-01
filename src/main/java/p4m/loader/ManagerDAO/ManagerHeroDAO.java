package p4m.loader.ManagerDAO;


import p4m.loader.D2Tables.D2Hero;
import p4m.loader.JsonPack.JsonHeroPack.JsonHero.Heroes;
import p4m.loader.WebDAO.WebHeroDAO;

/**
 * Created by soart on 08.04.2015.
 */
public class ManagerHeroDAO extends ManagerDAO
{

    @Override
    protected void saveOrUpdateArray(Object[] array) throws Exception {

    }

    @Override
    protected String getSQLQueryByCondition(String cond) {
        return null;
    }

    @Override
    protected boolean isReadOnly(Object obj) {
        return false;
    }

    @Override
    protected String getSQLQuery() {
        return null;
    }

    @Override
    protected D2Hero[] JsonToDBObject(Object[] objarr) {
        D2Hero[] d2hArr = new D2Hero[objarr.length];
        int i = 0;
        for(Heroes jsonher: (Heroes[])objarr)
        {
            d2hArr[i] = jsonher.toD2Hero();
            i++;
        }

        return d2hArr;
    }

    @Override
    protected Object[] getWeb() throws Exception {
        WebHeroDAO webheroDao = new WebHeroDAO();
        return webheroDao.getJsonTargetObject();
    }
}

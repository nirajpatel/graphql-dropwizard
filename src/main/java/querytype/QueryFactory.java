package querytype;

import com.gs.collections.impl.list.mutable.FastList;
import database.dao.DAO;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

/**
 * Created by Shanshan Jiang on 4/24/2016.
 */
public class QueryFactory {

    private static List<Class> queryList;

    static {
        queryList = FastList.newListWith(PersonQuery.class, DegreeQuery.class);
    }

    public static void createQueries(final DAO dao) {
        queryList.stream().forEach(clazz -> {
            try {
                clazz.getConstructor(DAO.class).newInstance(dao);
            } catch (NoSuchMethodException | IllegalAccessException | InstantiationException | InvocationTargetException e) {
                e.printStackTrace();
            }
        });
    }
}

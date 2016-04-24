package database.dao;

import io.dropwizard.hibernate.AbstractDAO;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import java.util.List;

/**
 * Created by Shanshan Jiang on 4/24/2016.
 */
public class DAO<T> extends AbstractDAO<T> {
    public DAO(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    public List<T> findByStringValues(Class clazz, String field, List<String> values) {
        Criteria criteria = currentSession().createCriteria(clazz);
        criteria.add(Restrictions.in(field, values));
        return criteria.list();
    }

    public List<T> findByIntegerValues(Class clazz, String field, List<Integer> values) {
        Criteria criteria = currentSession().createCriteria(clazz);
        criteria.add(Restrictions.in(field, values));
        return criteria.list();
    }

    public List<T> findTopRecords(Class clazz, int number) {
        Criteria criteria = currentSession().createCriteria(clazz);
        criteria.setMaxResults(number);
        return criteria.list();
    }
}

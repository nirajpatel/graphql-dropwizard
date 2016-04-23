package database.dao;


import database.entity.Degree;
import io.dropwizard.hibernate.AbstractDAO;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import java.util.List;

/**
 * Created by Shanshan Jiang on 4/10/2016.
 */
public class DegreeDAO extends AbstractDAO<Degree> {
    public DegreeDAO(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    public List findByStringValues(String field, List<String> values) {
        Criteria criteria = currentSession().createCriteria(Degree.class);
        criteria.add(Restrictions.in(field, values));
        return criteria.list();
    }
}

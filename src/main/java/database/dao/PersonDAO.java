package database.dao;

import database.entity.Person;
import io.dropwizard.hibernate.AbstractDAO;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import java.util.List;
import java.util.Optional;

/**
 * Created by Shanshan Jiang on 4/10/2016.
 */
public class PersonDAO extends AbstractDAO<Person> {

    public PersonDAO(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    public Optional<Person> findById(int id) {
        return Optional.ofNullable(get(id));
    }

    public List findTop10() {
        Criteria criteria = currentSession().createCriteria(Person.class);
        criteria.setMaxResults(10);
        return criteria.list();
    }

    public List findByIntegerValues(String field, List<Integer> values) {
        Criteria criteria = currentSession().createCriteria(Person.class);
        criteria.add(Restrictions.in(field, values));
        return criteria.list();
    }

    public List findByIntegerValue(String field, Integer value) {
        Criteria criteria = currentSession().createCriteria(Person.class);
        criteria.add(Restrictions.eq(field, value));
        return criteria.list();
    }

    public List findByStringValues(String field, List<String> values) {
        Criteria criteria = currentSession().createCriteria(Person.class);
        criteria.add(Restrictions.in(field, values));
        return criteria.list();
    }
}

package database.dao;

import database.entity.Person;
import io.dropwizard.hibernate.AbstractDAO;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import java.util.ArrayList;
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

    public List<Person> findTop10() {
        Criteria criteria = currentSession().createCriteria(Person.class);
        criteria.setMaxResults(10);
        return criteria.list();
    }

    public Optional<List<Person>> findByStringValue(List<String> fields, List<String> values) {
//        Criteria criteria = currentSession().createCriteria(Person.class);
        return null;
    }

    public List<Person> findByIds(ArrayList<Integer> ids) {
        Criteria criteria = currentSession().createCriteria(Person.class);
        criteria.add(Restrictions.in("id", ids));
        return criteria.list();
    }
}

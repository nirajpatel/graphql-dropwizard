package database.dao;


import database.entity.Degree;
import io.dropwizard.hibernate.AbstractDAO;
import org.hibernate.SessionFactory;

/**
 * Created by Shanshan Jiang on 4/10/2016.
 */
public class DegreeDAO extends AbstractDAO<Degree> {
    public DegreeDAO(SessionFactory sessionFactory) {
        super(sessionFactory);
    }
}

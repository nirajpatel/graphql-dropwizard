import database.dao.PersonDAO;
import database.entity.Degree;
import database.entity.Person;
import io.dropwizard.Application;
import io.dropwizard.db.DataSourceFactory;
import io.dropwizard.db.PooledDataSourceFactory;
import io.dropwizard.hibernate.HibernateBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import service.DummyService;
import service.GraphqlService;

/**
 * Created by Shanshan Jiang on 4/7/2016.
 */
public class MyApplication extends Application<MyConfiguration> {
    private static final Logger logger = LoggerFactory.getLogger(MyApplication.class);
    private final HibernateBundle<MyConfiguration> hibernateBundle = new HibernateBundle<MyConfiguration>(
            Person.class, Degree.class) {
        public PooledDataSourceFactory getDataSourceFactory(MyConfiguration configuration) {
            return configuration.getDataSourceFactory();
        }
    };

    public static void main(String[] args) throws Exception {
        String[] hardCodedArgs = {"server","Graphql-dropwizard.yml"};
        new MyApplication().run(hardCodedArgs);
    }

    @Override
    public void run(MyConfiguration configuration, Environment environment) throws Exception {
        final PersonDAO personDao = new PersonDAO(hibernateBundle.getSessionFactory());
        environment.jersey().register(new DummyService());
        environment.jersey().register(new GraphqlService(personDao));
    }

    @Override
    public void initialize(Bootstrap<MyConfiguration> bootstrap) {
//        bootstrap.addBundle(new ViewBundle());
        bootstrap.addBundle(hibernateBundle);
    }
}

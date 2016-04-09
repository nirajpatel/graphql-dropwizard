import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import service.DummyService;

/**
 * Created by Shanshan Jiang on 4/7/2016.
 */
public class MyApplication extends Application<MyConfiguration> {
    private static final Logger logger = LoggerFactory.getLogger(MyApplication.class);

    public static void main(String[] args) throws Exception {
        String[] hardCodedArgs = {"server","graphql-dropwizard.yml"};
        new MyApplication().run(hardCodedArgs);
    }

    @Override
    public void run(MyConfiguration configuration, Environment environment) throws Exception {
        final DummyService dummyService = new DummyService();
        environment.jersey().register(dummyService);
//        register(MultiPartFeature.class);
//        environment.jersey().register(MultiPartFeature.class);
    }

    @Override
    public void initialize(Bootstrap<MyConfiguration> bootstrap) {
//        bootstrap.addBundle(new ViewBundle());
    }
}

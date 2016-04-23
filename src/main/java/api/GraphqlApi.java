package api;

import io.dropwizard.hibernate.UnitOfWork;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import java.util.Map;

/**
 * Created by Shanshan Jiang on 4/10/2016.
 */
@Path("/graphql")
public interface GraphqlApi {
    @POST
    @UnitOfWork//indicates this a database related request
    @Consumes("text/plain")
    @Produces("application/json")
    Map<String, Object> graphqlRequest(@Context HttpServletRequest request);
}

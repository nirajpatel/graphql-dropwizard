package api;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import java.util.Map;

/**
 * Created by Shanshan Jiang on 4/7/2016.
 */
@Path("/hello")
public interface DummyApi {
    @POST
    @Consumes("text/plain")
    @Produces("application/json")
    Map<String, Object> getSomething(@Context HttpServletRequest request);
}

package api;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;

/**
 * Created by Shanshan Jiang on 4/7/2016.
 */
@Path("/hello")
public interface DummyApi {
    @POST
    String getSomething(@Context HttpServletRequest request);
}

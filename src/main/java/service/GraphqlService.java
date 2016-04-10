package service;

import api.Graphql;
import database.dao.PersonDAO;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * Created by Shanshan Jiang on 4/10/2016.
 */
public class GraphqlService implements Graphql {

    private PersonDAO personDAO;

    public GraphqlService (PersonDAO personDAO) {
        this.personDAO = personDAO;
    }

    public Map<String, Object> graphqlRequest(HttpServletRequest request) {
        String requestPayload = ServiceUtil.getRequestPayload(request);
        personDAO.findById(1);
        return null;
    }
}

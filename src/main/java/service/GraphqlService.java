package service;

import api.Graphql;
import database.dao.PersonDAO;
import graphql.GraphQL;
import graphql.schema.GraphQLSchema;
import querytype.PersonQuery;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * Created by Shanshan Jiang on 4/10/2016.
 */
public class GraphqlService implements Graphql {

    public GraphqlService(PersonDAO personDAO) {
        new PersonQuery(personDAO);
    }

    public Map<String, Object> graphqlRequest(HttpServletRequest request) {
        String requestPayload = ServiceUtil.getRequestPayload(request);

        GraphQLSchema schema = GraphQLSchema.newSchema()
                .query(PersonQuery.queryType)
                .build();
        return (Map<String, Object>) new GraphQL(schema).execute(requestPayload).getData();
    }
}

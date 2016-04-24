package service;

import api.GraphqlApi;
import graphql.GraphQL;
import graphql.schema.GraphQLSchema;
import querytype.Query;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * Created by Shanshan Jiang on 4/10/2016.
 */
public class GraphqlService implements GraphqlApi {

    public Map<String, Object> graphqlRequest(HttpServletRequest request) {
        String requestPayload = ServiceUtil.getRequestPayload(request);

        GraphQLSchema personSchema = GraphQLSchema.newSchema()
                .query(Query.queryType)
                .build();
        return (Map<String, Object>) new GraphQL(personSchema).execute(requestPayload).getData();
    }
}

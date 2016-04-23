package querytype;

import graphql.schema.GraphQLList;
import graphql.schema.GraphQLObjectType;

import static graphql.schema.GraphQLFieldDefinition.newFieldDefinition;
import static graphql.schema.GraphQLObjectType.newObject;

/**
 * Created by Shanshan Jiang on 4/23/2016.
 */
public class Query {
    public static GraphQLObjectType queryType = newObject()
            .name("QueryType")
            .field(newFieldDefinition()
                    .name("person")
                    .type(new GraphQLList(PersonQuery.personType))
                    .argument(PersonQuery.argumentList)
                    .dataFetcher(PersonQuery.fetchPersonData)
                    .build())
            .build();
}

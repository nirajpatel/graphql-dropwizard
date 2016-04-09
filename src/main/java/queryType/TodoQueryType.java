package queryType;

import graphql.schema.GraphQLObjectType;

import static graphql.Scalars.GraphQLBoolean;
import static graphql.Scalars.GraphQLID;
import static graphql.Scalars.GraphQLString;
import static graphql.schema.GraphQLFieldDefinition.newFieldDefinition;
import static graphql.schema.GraphQLObjectType.newObject;

/**
 * Created by Shanshan Jiang on 4/8/2016.
 */
public class TodoQueryType {

    public GraphQLObjectType create() {
        return newObject()
                .name("Todo")
                .field(newFieldDefinition()
                        .type(GraphQLID)
                        .name("id")
                        .build())
                .field(newFieldDefinition()
                        .type(GraphQLString)
                        .name("title")
                        .build())
                .field(newFieldDefinition()
                        .type(GraphQLBoolean)
                        .name("completed")
                        .build())
                .build();
    }

}

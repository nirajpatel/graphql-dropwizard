package sandbox;

import graphql.GraphQL;
import graphql.schema.*;

import java.util.Map;

import static graphql.Scalars.GraphQLString;
import static graphql.schema.GraphQLArgument.newArgument;
import static graphql.schema.GraphQLFieldDefinition.newFieldDefinition;
import static graphql.schema.GraphQLObjectType.newObject;

/**
 * Created by Shanshan Jiang on 4/7/2016.
 */
public class HumanQuery {
    static Human luke;
    static Human han;
    public static void main(String[] args) {
        setUpHumanData();
        GraphQLObjectType queryType = newObject()
                .name("QueryType")
                .field(newFieldDefinition()
                        .name("human")
                        .type(humanType)
                        .argument(newArgument() // defines what will be passed to human object
                                .name("id")
                                .description("id of the human")
                                .type(new GraphQLNonNull(GraphQLString))
                                .build())
                        // dataFetcher defines how data will be retrieved. Main logic suppose to be done here based on arguments.
                        // like joining tables. Or can directly return a result set of a SQL.
                        // FIXME: Separate to a single method
                        // TODO: Add friends matching, will need to use list for it. Still pending on how to do so
                        .dataFetcher(new DataFetcher() {
                            public Object get(DataFetchingEnvironment environment) {
                                return luke;
                            }
                        })
                        .build())
                .build();

        GraphQLSchema schema = GraphQLSchema.newSchema()
                .query(queryType)
                .build();
        Map<String, Object> result = (Map<String, Object>)new GraphQL(schema).execute(
                "{human(id:\"1000\") {name}}"
        ).getData();
        System.out.println(result);
    }

    public static GraphQLObjectType humanType = newObject()
            .name("Character")
            .description("A character in the Star Wars Trilogy")
            .field(newFieldDefinition()
                    .name("id")
                    .description("The id of the character.")
                    .type(new GraphQLNonNull(GraphQLString))
                    .build())
            .field(newFieldDefinition()
                    .name("name")
                    .description("The name of the character.")
                    .type(GraphQLString)
                    .build())
            .field(newFieldDefinition()
                    .name("friends")
                    .description("The friends of the character, or an empty list if they have none.")
                    .type(new GraphQLList(new GraphQLTypeReference("Character")))
                    .build())
            .build();

    private static void setUpHumanData() {
        han = new Human();
        han.setId(1002);
        han.setName("Han Solo");

        luke = new Human();
        luke.setId(1000);
        luke.setName("Luke Skywalker");
        luke.setFriends(han);
    }
}


